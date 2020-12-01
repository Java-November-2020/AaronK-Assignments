package com.aaronkirchhoff.show.controllers;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aaronkirchhoff.show.models.Book;
import com.aaronkirchhoff.show.services.BookService;

@Controller
public class BookController {
private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    
    @RequestMapping("/books/{id}")
    public String getSingleBook(Model model, @PathVariable("id") Long id) {
        Book book = bookService.getSingleBook(id);
        model.addAttribute("book", book);
        return "/books/book_index.jsp";
    }     
    
//    @RequestMapping("/books/{id}")
//    public String findBookById(Model model, @PathVariable("id") Long id) {
//        Book book = bookService.findBookById(id);
//        model.addAttribute("book", book);
//        return "/books/book_index.jsp";
//    }    
    
    
    
//    @RequestMapping("/books")
//    public String index(Model model) {
//        List<Book> books = this.bookService.getAllBooks();
//        model.addAttribute("Book", books);
//        return "/books/book_index.jsp";
//    }
    
//    @RequestMapping("/books")
//    public String index() {
//      return "/books/book_index.jsp";
//
//    
//    }
    


}
