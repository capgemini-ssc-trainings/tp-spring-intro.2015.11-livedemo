package com.capgemini.spring.rest;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public BookEntity findBook(@PathVariable("bookId") Long bookId) {
        return bookService.findBookById(bookId);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST, consumes = "application/json")
    public String addBook(@RequestBody BookEntity bookEntity) {
        return "My First Book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public String updateBook() {
        return "My First Book";
    }
}
