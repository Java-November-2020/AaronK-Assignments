package com.aaronkirchhoff.show.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaronkirchhoff.show.models.Book;

@Repository

public interface ShowRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();

}
