package com.aaronkirchhoff.languages.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.aaronkirchhoff.languages.models.CodingLanguage;
import com.aaronkirchhoff.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
//	dependency injection so it can talk to repository
	private LanguageRepository sRepo;

	public LanguageService(LanguageRepository repo) {
		this.sRepo = repo;
	}

	
	public List<CodingLanguage> getAllLanguages() {
		return this.sRepo.findAll();
	}
	
	public CodingLanguage createLanguage(CodingLanguage newLanguage) {
		return this.sRepo.save(newLanguage);
	}
	
//	get a single language
	public CodingLanguage getSingleLanguage(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
//	delete a language
	public void deleteLanguage(Long id) {
		this.sRepo.deleteById(id);
	}
	
//	update/ edit an entry
	public CodingLanguage updateLanguage(Long id, CodingLanguage updateLanguage) {
        return this.sRepo.save(updateLanguage);

	}
}
