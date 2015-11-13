package com.capgemini.spring.repository;

import com.capgemini.spring.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long>, SearchByCriteriaRepository {

    List<BookEntity> findBookByTitleLike(@Param("title")String title);

    @Query("select book from BookEntity book where book.title like :title%")
    List<BookEntity> findBookByTitle2(@Param("title")String title);
}
