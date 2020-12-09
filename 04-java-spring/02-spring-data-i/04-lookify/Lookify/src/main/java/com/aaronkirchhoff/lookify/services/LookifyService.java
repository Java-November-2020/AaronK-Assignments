package com.aaronkirchhoff.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronkirchhoff.lookify.models.Song;
import com.aaronkirchhoff.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
//	dependency injection so it can talk to repository
	private LookifyRepository lRepo;

	public LookifyService(LookifyRepository repo) {
		this.lRepo = repo;
	}

	public List<Song> getAllSongs() {
		return this.lRepo.findAll();
	}
	
	public Song createSong(Song newSong) {
		return this.lRepo.save(newSong);
	}
	
	public Song getSingleSong(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public void deleteSong(Long id) {
		this.lRepo.deleteById(id);
	}
	
	public List<Song> songsContainingArtist(String artist) {
		return lRepo.findByArtistContaining(artist);
	}
	
	public List<Song> topTenByRating() {
		return lRepo.findTop10ByOrderByRatingDesc();
	}
}
