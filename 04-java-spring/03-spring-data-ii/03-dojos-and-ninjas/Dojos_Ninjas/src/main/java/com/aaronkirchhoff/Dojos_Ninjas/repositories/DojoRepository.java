package com.aaronkirchhoff.Dojos_Ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.Dojos_Ninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {

	List<Dojo> findAll();

}
