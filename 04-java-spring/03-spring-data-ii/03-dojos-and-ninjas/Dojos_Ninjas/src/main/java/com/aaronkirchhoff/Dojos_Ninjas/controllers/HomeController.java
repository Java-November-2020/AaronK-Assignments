package com.aaronkirchhoff.Dojos_Ninjas.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronkirchhoff.Dojos_Ninjas.models.Dojo;
import com.aaronkirchhoff.Dojos_Ninjas.models.Ninja;
import com.aaronkirchhoff.Dojos_Ninjas.services.Dojo_NinjasServices;


@Controller
public class HomeController {
//	dependency injection= to service, use lowercase languageService in controller, to link it to LanguageService Service file.
	private final Dojo_NinjasServices dnService;

	public HomeController(Dojo_NinjasServices dnService) {
		this.dnService = dnService;
	}
	
// root route, default
	@RequestMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "NewDojo.jsp";
	}
//	home page, front page, need modelattribute to work. just type /dojos in url.
	@RequestMapping("/dojos")
	public String Index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("dojos", dnService.allDojos());
		return "NewDojo.jsp";
	}
// post request, adding new dojos
	@RequestMapping(value="/addDojo", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors())
			return "NewDojo.jsp";
		this.dnService.createDojo(dojo);
		return "redirect:/dojos";
	}
	
//	to get to the ninja page, line 53, dojo id and info to populate the drop down field. type /ninjas/new in url.
	@RequestMapping("/ninjas/new")
	public String NewNinja(@ModelAttribute("ninjas") Ninja ninja, Model model) {
		model.addAttribute("dojos", this.dnService.allDojos());
		return "NewNinja.jsp";
	}
	
// to submit a new ninja info
	@RequestMapping(value = "/add/ninjas", method=RequestMethod.POST)
	public String CreateNinja(@Valid @ModelAttribute("ninjas") Ninja ninja, BindingResult result, Model model) {
		model.addAttribute("dojos", this.dnService.allDojos());
		if(result.hasErrors())
			return "/NewNinja.jsp";
		dnService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
//	type /dojos/{id} to get the dojo and ninjas belonging to it page
	@RequestMapping("/dojos/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.dnService.findDojo(id));
		return "ThisDojo.jsp";
	}
}
