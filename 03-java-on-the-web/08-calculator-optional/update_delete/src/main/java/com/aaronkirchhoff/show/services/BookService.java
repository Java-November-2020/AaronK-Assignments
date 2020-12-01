package com.aaronkirchhoff.show.services;

//import java.util.ArrayList;

//import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronkirchhoff.show.models.Book;
import com.aaronkirchhoff.show.repositories.ShowRepository;

@Service
public class BookService {
//	dependency injection, have to link repository and services class together with following line. sRepo is just a variable name.
	private ShowRepository sRepo;

	public BookService(ShowRepository repo) {
		this.sRepo = repo;
	}

// belwo is the method i want to use to input new instances of my model. hmmm...
//	public Book createBookOldWay(String title, String description, String language, int number_of_pages) {
//		Book newBook = new Book("The Odyssey", "Ancient Greek epic poem", "english", 475);
//		return this.sRepo.save(newBook);
//	}

//	let's create some crud commands/ methods.
//	get all books
	public List<Book> getAllBooks() {
		return this.sRepo.findAll();
	}

//	get a single book
	public Book getSingleBook(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}

//	create a new book
	public Book createBook(Book newBook) {
		return this.sRepo.save(newBook);
	}

//	delete a book
	public void deleteBook(Long id) {
		this.sRepo.deleteById(id);
	}

//	update/ edit an entry
	public Book updateBook(Long id, Book book) {
        return this.sRepo.save(book);

	}

//	public Book findBookById(Long id) {
//        if (id < sRepo.size()){
//            return sRepo.findById(id);
//        }else{
//            return null;
//        }

}
