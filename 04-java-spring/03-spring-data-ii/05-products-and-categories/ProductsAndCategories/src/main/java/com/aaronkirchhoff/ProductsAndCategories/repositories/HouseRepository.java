package com.aaronkirchhoff.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.ProductsAndCategories.models.House;
import com.aaronkirchhoff.ProductsAndCategories.models.Wizard;

public interface HouseRepository extends CrudRepository<House, Long>{
	List<House> findAll();
	
	List<House> findByWizardsNotContaining(Wizard newWizard);


}
