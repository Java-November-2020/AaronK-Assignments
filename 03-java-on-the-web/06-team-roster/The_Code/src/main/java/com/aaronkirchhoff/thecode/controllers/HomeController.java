package com.aaronkirchhoff.thecode.controllers;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	private Boolean isCorrectCode(String guess) {
		return guess.equals("Bushido");
	}

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/test", method=RequestMethod.POST)
	public String test(@RequestParam(value="passcode") String passcode,
		Model model, RedirectAttributes rAttributes) {
		if(isCorrectCode(passcode)) {
			return "redirect:/code";
			
		}
		rAttributes.addFlashAttribute("error", "You must train harder Padawan.");
		return "redirect:/";		
		
	}
	
	
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
