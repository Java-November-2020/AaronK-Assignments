package com.aaronkirchhoff.DojoOverflow.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.DojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findAll();

}
