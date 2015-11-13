package com.capgemini.spring.repository.impl;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.model.BookSearchCriteria;
import com.capgemini.spring.repository.SearchByCriteriaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookRepositoryImpl implements SearchByCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BookEntity> findBySearchCriteria(BookSearchCriteria bookSearchCriteria) {
        return null;
    }
}
