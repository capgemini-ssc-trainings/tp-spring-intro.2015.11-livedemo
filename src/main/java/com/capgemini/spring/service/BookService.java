package com.capgemini.spring.service;

import com.capgemini.spring.model.BookEntity;

public interface BookService {

    BookEntity findBookById(long bookId);
}
