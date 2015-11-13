package com.capgemini.spring.service.impl;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public BookEntity findBookById(long bookId) {
        return new BookEntity(bookId, "BookTitle", "BookAuthor");
    }
}
