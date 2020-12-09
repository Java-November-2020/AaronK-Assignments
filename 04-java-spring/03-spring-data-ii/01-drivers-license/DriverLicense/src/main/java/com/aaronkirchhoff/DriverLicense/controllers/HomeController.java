package com.aaronkirchhoff.DriverLicense.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronkirchhoff.DriverLicense.models.license;
import com.aaronkirchhoff.DriverLicense.models.person;
import com.aaronkirchhoff.DriverLicense.services.DriverLicenseService;

@Controller
public class HomeController {
//	dependency injection= to service, use lowercase languageService in controller, to link it to LanguageService Service file.
	private final DriverLicenseService dLicenseService;

	public HomeController(DriverLicenseService dLicenseService) {
		this.dLicenseService = dLicenseService;
	}
	
// for my root route, i need a very simple display function to show the page, but if it has a form to fill out, i need to pass in @ModelAttribute so the form can be ready to fill out, otherwise you get that error: neither bindingresult nor... blah blah.
	@RequestMapping("/")
	public String index(@ModelAttribute("person") person person) {
		return "PersonsNew.jsp";
	}
	
	@RequestMapping(value="/add/person", method=RequestMethod.POST)
	public String CreatePerson(@Valid @ModelAttribute("person") person person, BindingResult result) {
		if(result.hasErrors() ) {
			return "PersonsNew.jsp";
		}
		dLicenseService.createPerson(person);
		return "redirect:/";
	}
	
//	to get to the license page, lines 46, 47 bring Person id and info to populate the drop down field.
	@RequestMapping("/licenses/new")
	public String NewLicense(@ModelAttribute("license") license license, Model model) {
		List<person> unlicensed = dLicenseService.getUnlicensedPeople();
		model.addAttribute("person", unlicensed);
		return "LicensesNew.jsp";
	}
	
// to submit a new license info
	@RequestMapping(value = "/add/license", method=RequestMethod.POST)
	public String CreateLicense(@Valid @ModelAttribute("license") license license, BindingResult result) {
		if(result.hasErrors())
			return "/LicensesNew.jsp";
		dLicenseService.createLicense(license);
		return "redirect:/";
	}

//	just type in the id after the root route and it takes you to a persons page.
	@RequestMapping("/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", dLicenseService.getPerson(id));
		return "ThisPerson.jsp";
	}
}
