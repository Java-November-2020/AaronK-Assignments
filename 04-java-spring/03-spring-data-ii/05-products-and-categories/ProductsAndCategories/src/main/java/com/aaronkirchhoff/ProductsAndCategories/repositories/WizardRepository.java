package com.aaronkirchhoff.ProductsAndCategories.repositories;

import java.util.List;



import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.ProductsAndCategories.models.House;
import com.aaronkirchhoff.ProductsAndCategories.models.Wizard;

public interface WizardRepository extends CrudRepository<Wizard, Long>{
	List<Wizard> findAll();
	
//	where does findByHouseNotContains come from???? how doe sit know to how to read that?
//	spring JPA query https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
//	SPRING JPA QUERY METHODS AAAAHHHHHHHHH
//	creating a list but im looking at the specific house that passed, and the wizards not in it. Houses in the name below is coming from the model.
	List<Wizard> findByHousesNotContaining(House newHouse);
	
//	List<Wizard> findByWizardIdIsNull();



}
