package com.aaronkirchhoff.lookify.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.lookify.models.Song;

public interface LookifyRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();

	List<Song> findByArtistContaining(String artist);
	
//	this really is magic, JPA recognizes here that Top10 means the top tne in our database of something, then saying By Rating, it knows that rating is an attribute of our model, and adding Desc sorts in descending order, wow!
	List<Song> findTop10ByOrderByRatingDesc();



}
