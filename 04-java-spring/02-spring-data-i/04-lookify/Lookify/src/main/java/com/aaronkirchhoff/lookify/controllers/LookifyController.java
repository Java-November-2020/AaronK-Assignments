package com.aaronkirchhoff.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaronkirchhoff.lookify.models.Song;
import com.aaronkirchhoff.lookify.services.LookifyService;

@Controller
public class LookifyController {
//	dependency injection= to service, use lowercase languageService in controller, to link it to LanguageService Service file.
	private final LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}

	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}	
	
//	@RequestMapping("dashboard")
//	public String dashboard() {
//		return "dashboard.jsp";
//	}
	
	@RequestMapping("/dashboard")
    public String home(Model model) {
        model.addAttribute("song", new Song(null, null, 0));
        model.addAttribute("songs", lookifyService.getAllSongs());
        return "dashboard.jsp";
    }
	
// the add a song page, but in order to get it to show up, you need to pass a model attribute for the form on this page to read, also need bonding result thingy.
	@RequestMapping("/addSong")
	public String addSong(@ModelAttribute("song") Song song) {
		return "AddNew.jsp";
	}

//	and here we have a method that inputs dats into our database, checks for errors, and returns to the dashboard.
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
		if (result.hasErrors()) {
	            return "AddNew.jsp";
	    } else {
	    	lookifyService.createSong(song);
	            return "redirect:/dashboard";
	    }
	}
	
	@GetMapping("/currentsong/{id}")
	public String getSingleSong(Model model, @PathVariable("id") Long id) {
		Song song = this.lookifyService.getSingleSong(id);
		model.addAttribute("song", song);
		return "/this_song.jsp";
	}
	
	@RequestMapping(value="/delete/{id}")
    public String destroySong(@PathVariable("id") Long id) {
        lookifyService.deleteSong(id);
        return "redirect:/dashboard";
    }
	
//	search button
	@RequestMapping("/songs/search")
	public String Search(@RequestParam("artist")String artist, Model model) {
		model.addAttribute("songs", lookifyService.songsContainingArtist(artist));
		model.addAttribute("artist", artist);
		return "ArtistSearchPage.jsp";
	}
	
	@RequestMapping("/songs/topTen")
	public String TopTen(Model model) {
		model.addAttribute("songs", lookifyService.topTenByRating());
		return "/topTen.jsp";
	}
}