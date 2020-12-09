package com.aaronkirchhoff.DriverLicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronkirchhoff.DriverLicense.models.license;
import com.aaronkirchhoff.DriverLicense.models.person;
import com.aaronkirchhoff.DriverLicense.repositories.DriverLicenseRepository;
import com.aaronkirchhoff.DriverLicense.repositories.TheLicenseRepository;

@Service
public class DriverLicenseService {
//	dependency injection so it can talk to repository
	private DriverLicenseRepository lRepo;
	private  TheLicenseRepository licRepo;


	public DriverLicenseService(DriverLicenseRepository repo, TheLicenseRepository licRepo) {
		this.lRepo = repo;
		this.licRepo = licRepo;
	}
	
	
	
	public List<person> getPeople() {
		return lRepo.findAll();
	}
	
	public person createPerson(person newPerson) {
		return this.lRepo.save(newPerson);
	}
	
	public license createLicense(license l) {
		l.setNumber(this.generateLicenseNumber());
		return licRepo.save(l);
	}
	
	public int generateLicenseNumber() {
		license l = licRepo.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return (largestNumber);
	}
	
	public List<person> getUnlicensedPeople() {
		return lRepo.findByLicenseIdIsNull();
	}

	public person getPerson(Long id) {
		return lRepo.findById(id).orElse(null);
	}
}
