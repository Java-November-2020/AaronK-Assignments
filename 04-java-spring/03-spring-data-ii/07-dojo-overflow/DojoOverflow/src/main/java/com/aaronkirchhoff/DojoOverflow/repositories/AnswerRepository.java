package com.aaronkirchhoff.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.DojoOverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>  {
	
	List<Answer> findAll();


}
