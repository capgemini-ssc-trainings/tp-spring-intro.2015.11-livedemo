package com.capgemini.spring.repository;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.model.BookSearchCriteria;

import java.util.List;

public interface SearchByCriteriaRepository {

    List<BookEntity> findBySearchCriteria(BookSearchCriteria bookSearchCriteria);
}
