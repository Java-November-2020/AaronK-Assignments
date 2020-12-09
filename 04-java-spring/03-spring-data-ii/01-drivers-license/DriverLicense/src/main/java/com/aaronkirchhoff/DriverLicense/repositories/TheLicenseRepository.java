package com.aaronkirchhoff.DriverLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.DriverLicense.models.license;

public interface TheLicenseRepository extends CrudRepository<license, Long>{
	public List<license> findAll();
	public license findTopByOrderByNumberDesc();

}
