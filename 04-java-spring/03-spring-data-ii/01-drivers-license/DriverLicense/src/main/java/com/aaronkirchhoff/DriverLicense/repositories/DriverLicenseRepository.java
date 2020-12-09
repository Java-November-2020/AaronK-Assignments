package com.aaronkirchhoff.DriverLicense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.DriverLicense.models.person;



public interface DriverLicenseRepository extends CrudRepository<person, Long>{
	List<person> findAll();
	
	@Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
	List<person> findByNoLicense();
	
	List<person> findByLicenseIdIsNull();


}
