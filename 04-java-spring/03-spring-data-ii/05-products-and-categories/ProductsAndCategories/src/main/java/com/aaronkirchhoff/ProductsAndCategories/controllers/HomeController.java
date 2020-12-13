package com.aaronkirchhoff.ProductsAndCategories.controllers;


import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaronkirchhoff.ProductsAndCategories.models.House;
import com.aaronkirchhoff.ProductsAndCategories.models.Wizard;
import com.aaronkirchhoff.ProductsAndCategories.services.AppService;

@Controller
public class HomeController {
//	dependency injection= to service, use lowercase languageService in controller, to link it to LanguageService Service file.
	private final AppService appService;

	public HomeController(AppService appService) {
		this.appService = appService;
	}
	
// root route, default, this is where you add a wizard
	@RequestMapping("/")
	public String wizardindex(@ModelAttribute("wizard") Wizard wizard) {
		return "NewWizard.jsp";
	}
	
	
// post request, adding new wizards
	@RequestMapping(value="/wizard/new", method=RequestMethod.POST)
	public String CreateWizard(@Valid @ModelAttribute("wizard") Wizard wizard, BindingResult result) {
		if(result.hasErrors())
			return "NewWizard.jsp";
		this.appService.createWizard(wizard);
		return "redirect:/";
	}
	
// this page route is where you add a house
	@RequestMapping("/house")
	public String houseindex(@ModelAttribute("house") House house) {
		return "NewHouse.jsp";
	}
	
// post request, adding new houses
	@RequestMapping(value="/house/new", method=RequestMethod.POST)
	public String CreateHouse(@Valid @ModelAttribute("house") House house, BindingResult result) {
		if(result.hasErrors())
			return "NewHouse.jsp";
		this.appService.createHouse(house);
		return "redirect:/house";
	}
	

// this page route is where you show a specific wizard and let them join a house.
//	Line 66, Wizard, is defining a variable, that's it. that varibale is thisWizard and we're setting equal to appService.getWizardByID(id);
//	line 70 is creating a model attribute to apss to our jsp. that model name is notPartOfWizard. and we're attatching it to... basicaly we're saying hey, harry potter, i need to look for houses your not a part of. go to appService, look for a list of houses not a part of who?? thisWizard, the variable equal to getWizardbyID, which ID? the wizard Id we brought for mthe URL!
	@RequestMapping("/Wizard/{id}")
	public String ThisWizardPage(@PathVariable("id") Long id, Model model) {
		Wizard thisWizard = appService.getWizardByID(id);
		model.addAttribute("notPartOfWizard", this.appService.findHousesNotInWizard(thisWizard));
		model.addAttribute("wizard", thisWizard);

		return "ThisWizard.jsp";
	}
	
// for a wizard to join a new house, run this...
	@PostMapping("/wizardjoinhouse/{id}")
	public String WizardJoinHouse(@RequestParam("wizard") Long wizard_id, @RequestParam("notPartOfWizard") Long house_id, 	@PathVariable("id") Long kind ) {
		House myHouse = appService.getHouseByID(house_id);
		Wizard myWizard = appService.getWizardByID(wizard_id);
		List<House> listOfHouses = myWizard.getHouses();
		listOfHouses.add(myHouse);
		appService.updateWizard(myWizard);
		return "redirect:/Wizard/" + kind;
	}
	
	
	
//	to get to the page with houses and you can add a wizard to them
//	what do I need to pass in here for my ThisHouse.jsp to read my For loop correctly?
//	a jstl form needs to ouch on every model attribute.
//	@RequestParameter grabs from the front end. the form.

	@RequestMapping("/House/{id}")
	public String ThisHousePage( @PathVariable("id") Long id, Model model) {
//		House below is defining a variable we can use many times below, make sour life easier.
		House thisHouse = appService.getHouseByID(id);
		model.addAttribute("notInHouse", this.appService.findWizardsNotInHouse(thisHouse));
		model.addAttribute("house", thisHouse);
		return "ThisHouse.jsp";
	}
	
// for a house to allow a new wizard, run this...
//	requestParam is grabbing the names, house and wizard from my form. then get a specific wizard from the wizard_id, and specific house from house_id, get the full list of wizards give it a variable name listOfWizards and make it equal to all the wizards we've added to the house, call it newHouse (the House model variable name here that we set, getWizards is the getter method from the house model file. ???? whaaa
	@PostMapping("/housesacceptwizards/{id}")
	public String houseAcceptsWizard(@RequestParam("notInHouse") Long wizard_id, @RequestParam("house") Long house_id, @PathVariable("id") Long kind, Model model ) {

		Wizard newWizard = appService.getWizardByID(wizard_id);
		House newHouse = appService.getHouseByID(house_id);
		List<Wizard> listOfWizards = newHouse.getWizards();
		model.addAttribute("wizard", listOfWizards);		
		listOfWizards.add(newWizard);
		appService.updateHouse(newHouse);
		return "redirect:/House/" + kind;
	}
}



