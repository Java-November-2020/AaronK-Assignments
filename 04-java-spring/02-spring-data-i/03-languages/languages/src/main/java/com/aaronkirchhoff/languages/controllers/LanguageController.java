package com.aaronkirchhoff.languages.controllers;

import javax.validation.Valid;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronkirchhoff.languages.models.CodingLanguage;


import com.aaronkirchhoff.languages.services.LanguageService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
public class LanguageController {
	
//	dependency injection= to service, use lowercase languageService in controller, to link it to LanguageService Service file.
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@RequestMapping("/")
	public String front() {
		return "index.jsp";
		
	}
	@RequestMapping("/language")
    public String home(Model model) {
        model.addAttribute("language", new CodingLanguage(null, null, 0));
        model.addAttribute("languages", languageService.getAllLanguages());
        return "index.jsp";
    }
	
	@RequestMapping(value="/language/add", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") CodingLanguage language, BindingResult result, Model model) {
        model.addAttribute("languages", languageService.getAllLanguages());
		if (result.hasErrors()) {
	            return "index.jsp";
	    } else {
	    	languageService.createLanguage(language);
	            return "redirect:/language";
	    }
	}
	
	@GetMapping("/currentlanguage/{id}")
	public String getSingleLanguage(Model model, @PathVariable("id") Long id) {
		CodingLanguage language = this.languageService.getSingleLanguage(id);
		model.addAttribute("language", language);
		return "/this_language.jsp";
	}
	
//	delete an entry
	@RequestMapping(value="/delete/{id}")
    public String destroyLanguagek(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/language";
    }
	
	@RequestMapping("/update/{id}")
    public String editEntry(@PathVariable("id") Long id, Model model) {
		CodingLanguage language = languageService.getSingleLanguage(id);
        if (language != null){
            model.addAttribute("language", language);
            return "edit_language.jsp";
        }else{
            return "redirect:/language";
        }
    }
	
    @PostMapping("/updated/{id}")
    public String updateEntry(@PathVariable("id") Long id, @Valid @ModelAttribute("language") CodingLanguage language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_language.jsp";
        }else{
            languageService.updateLanguage(id, language);
            return "redirect:/language";
        }
    }
	
	


}
