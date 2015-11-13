package com.capgemini.spring.service.impl;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.repository.BookRepository;
import com.capgemini.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity findBookById(long bookId) {
        return bookRepository.findOne(bookId);
    }
}
