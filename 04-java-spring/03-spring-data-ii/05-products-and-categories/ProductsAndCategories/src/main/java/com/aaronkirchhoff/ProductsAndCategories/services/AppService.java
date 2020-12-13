package com.aaronkirchhoff.ProductsAndCategories.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.aaronkirchhoff.ProductsAndCategories.models.House;
import com.aaronkirchhoff.ProductsAndCategories.models.Wizard;
import com.aaronkirchhoff.ProductsAndCategories.repositories.HouseRepository;
import com.aaronkirchhoff.ProductsAndCategories.repositories.WizardRepository;
//import com.aaronkirchhoff.ProductsAndCategories.repositories.WizardsAndHousesRepository;



@Service
public class AppService {
	private final WizardRepository wRepo;
	private final HouseRepository hRepo;
//	private final WizardsAndHousesRepository whRepo;

	public AppService(WizardRepository wRepo, HouseRepository hRepo) {
		this.wRepo = wRepo;
		this.hRepo = hRepo;
//		this.whRepo = whRepo;

	}
	
	public List<Wizard> allWizards() {
		return wRepo.findAll();
	}
	
	public Wizard createWizard(Wizard wizard) {
		return wRepo.save(wizard);
	}
	
	public List<House> allHouses() {
		return this.hRepo.findAll();
	}
	
	public House createHouse(House house) {
		return hRepo.save(house);
	}
	public House updateHouse(House house) {
		return hRepo.save(house);
	}
	
	public Wizard updateWizard(Wizard wizard) {
		return wRepo.save(wizard);
	}


	public List<House> findHousesNotInWizard(Wizard newWizard) {
		return hRepo.findByWizardsNotContaining(newWizard);
	}
	
//	I need a list of wizards, where do i I want to look for that list? in the house id i passed here for this parameter. then i want to check my wizard repo, for a a house that does not contain wizards? sort of. i dunno
	public List<Wizard> findWizardsNotInHouse(House newHouse) {
		return wRepo.findByHousesNotContaining(newHouse);
	}
	
//	public List<Wizard> findWizardsNotInHouse() {
//		return wRepo.findByWizardIdIsNull();
//	}
	
	public Wizard getWizardByID(Long id) {
		return wRepo.findById(id).orElse(null);
	}
	
	public House getHouseByID(Long id) {
		return hRepo.findById(id).orElse(null);
	}
	
	
}
