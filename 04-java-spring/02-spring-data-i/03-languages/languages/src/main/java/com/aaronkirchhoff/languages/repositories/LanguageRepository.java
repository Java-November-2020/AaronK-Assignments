package com.aaronkirchhoff.languages.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaronkirchhoff.languages.models.CodingLanguage;

@Repository
public interface LanguageRepository extends CrudRepository<CodingLanguage, Long> {
	List<CodingLanguage> findAll();

}

