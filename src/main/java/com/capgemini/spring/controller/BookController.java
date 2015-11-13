package com.capgemini.spring.controller;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book-list")
    public String bookList(Model model) {
        List<BookEntity> books = bookService.findAll();
        model.addAttribute("books", books);
        return "bookList";
    }
}
