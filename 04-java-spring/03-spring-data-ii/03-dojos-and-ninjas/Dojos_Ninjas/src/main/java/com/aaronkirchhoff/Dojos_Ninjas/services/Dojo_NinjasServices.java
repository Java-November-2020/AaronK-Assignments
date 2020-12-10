package com.aaronkirchhoff.Dojos_Ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronkirchhoff.Dojos_Ninjas.models.Dojo;
import com.aaronkirchhoff.Dojos_Ninjas.models.Ninja;
import com.aaronkirchhoff.Dojos_Ninjas.repositories.DojoRepository;
import com.aaronkirchhoff.Dojos_Ninjas.repositories.NinjaRepository;

@Service
public class Dojo_NinjasServices {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	public Dojo_NinjasServices(DojoRepository dRepo, NinjaRepository nRepo) {
		this.dojoRepo = dRepo;
		this.ninjaRepo = nRepo;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}

}
