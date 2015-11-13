package com.capgemini.spring.service;

import com.capgemini.spring.model.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity findBookById(long bookId);

    List<BookEntity> findAll();
}
