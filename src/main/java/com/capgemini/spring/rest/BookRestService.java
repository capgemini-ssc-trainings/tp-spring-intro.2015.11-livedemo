package com.capgemini.spring.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookRestService {

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String findBook(@RequestParam(value = "bookId", required = false) Long bookId) {
        return "My First Book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook() {
        return "My First Book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public String updateBook() {
        return "My First Book";
    }
}
