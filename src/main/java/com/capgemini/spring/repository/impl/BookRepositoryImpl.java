package com.capgemini.spring.repository.impl;

import com.capgemini.spring.model.BookEntity;
import com.capgemini.spring.model.BookSearchCriteria;
import com.capgemini.spring.model.QBookEntity;
import com.capgemini.spring.repository.SearchByCriteriaRepository;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookRepositoryImpl implements SearchByCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BookEntity> findBySearchCriteria(BookSearchCriteria bookSearchCriteria) {
        QBookEntity bookEntity = QBookEntity.bookEntity;
        JPAQuery query = new JPAQuery(entityManager).from(bookEntity);

        if (bookSearchCriteria != null) {
            BooleanBuilder whereBuilder = new BooleanBuilder();
            if (StringUtils.hasText(bookSearchCriteria.getTitle())) {
                whereBuilder.and(bookEntity.title.equalsIgnoreCase(bookSearchCriteria.getTitle()));
            }
            if (StringUtils.hasText(bookSearchCriteria.getAuthor())) {
                whereBuilder.and(bookEntity.authors.containsIgnoreCase(bookSearchCriteria.getAuthor()));
            }
            query.where(whereBuilder);
        }
        return query.list(bookEntity);
    }
}
