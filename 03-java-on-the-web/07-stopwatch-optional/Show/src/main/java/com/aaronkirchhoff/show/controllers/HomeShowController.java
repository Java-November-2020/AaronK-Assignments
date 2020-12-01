package com.aaronkirchhoff.show.controllers;

import java.util.List;


import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronkirchhoff.show.models.Book;
import com.aaronkirchhoff.show.services.BookService;

@Controller
public class HomeShowController {

//	need to do dependency injections so our home controller can talk to services, can talk to repositiry...
	private BookService bService;
	
	public HomeShowController(BookService service) {
		this.bService = service;
	}
	
//	@RequestMapping("/")
//	public String home(@PathVariable("id") Long id, Model model) {
//		System.out.println("hey is my backend on??");
//		model.addAttribute("Book", bService.getSingleBook(id));
//		return "index.jsp";
//	} 
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/showbooks")
	public List<Book> index(){
		return this.bService.getAllBooks();
	}
	
	
//	get a single book, a specific one by id
	@RequestMapping("/{id}")
	public Book getBook(@PathVariable("id")Long id) {
		return this.bService.getSingleBook(id);
	}
	
//	this method is a post request, submitting user info form the front end.
	@RequestMapping(value="/new", method=RequestMethod.POST)
		public Book create(Book book) {
		return this.bService.createBook(book);
		
	}
	
	
//	delete an entry
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public Book edit(@PathVariable("id") Long id, Book updatedBook) {
		return this.bService.updateBook(updatedBook);
		
	}
	
	


}

