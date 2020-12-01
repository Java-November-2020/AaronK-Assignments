package com.aaronkirchhoff.show.controllers;

//import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronkirchhoff.show.models.Book;
import com.aaronkirchhoff.show.services.BookService;
//import javax.validation.Valid;

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

//	@RequestMapping("/showbooks")
//	public List<Book> index() {
//		return this.bService.getAllBooks();
//	}

//	get a single book, a specific one by id
//	@RequestMapping("/{id}")
//	public Book getBook(@PathVariable("id") Long id) {
//		return this.bService.getSingleBook(id);
//	}

//	this method is a post request, submitting user info form the front end.
//	@RequestMapping(value = "/new", method = RequestMethod.POST)
//	public Book create(Book book) {
//		return this.bService.createBook(book);
//
//	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/NewBook.jsp";
	}
	
//	to add a book
	@RequestMapping(value="/books/add", method=RequestMethod.POST)
	public String create(@ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
	            return "/books/NewBook.jsp";
	    } else {
	            bService.createBook(book);
	            return "redirect:/books";
	    }
	}


//	delete an entry
	@RequestMapping(value="/delete/{id}")
    public String destroyBook(@PathVariable("id") Long id) {
        bService.deleteBook(id);
        return "redirect:/books";
    }
	
	
	
	@RequestMapping("/update/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bService.getSingleBook(id);
        if (book != null){
            model.addAttribute("book", book);
            return "/books/editbook.jsp";
        }else{
            return "redirect:/books";
        }
    }
	
    @PostMapping("/updated/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/editbook.jsp";
        }else{
            bService.updateBook(id, book);
            return "redirect:/books";
        }
    }
    // ...

	

//	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//	public Book edit(@PathVariable("id") Long id, Book updatedBook) {
//		return this.bService.updateBook(updatedBook);
//
//	}
	
//	@RequestMapping("/update/{id}")
//	public String editBook(@PathVariable("id") Long id, Book book, Model model) {
//        Book book1 = bService.updateBook(id, book);
//        if (book1 != null){
//            model.addAttribute("book", book);
//            return "/books/editbook.jsp";
//        }else{
//            return "redirect:/books";
//        }
//    }
	
//	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
//	public String edit(@PathVariable("id") Long id, Book updatedBook, Model model) {
//		 Book book1 = bService.updateBook(id, updatedBook);
//		 if (book1 != null){
//			 model.addAttribute("book", book1);
//           return "/books/editbook.jsp";
//		 }else{
//			 return "redirect:/books";
//		 }
//       
//	}
}

	

