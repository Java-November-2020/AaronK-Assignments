package com.aaronkirchhoff.Dojos_Ninjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.Dojos_Ninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}
