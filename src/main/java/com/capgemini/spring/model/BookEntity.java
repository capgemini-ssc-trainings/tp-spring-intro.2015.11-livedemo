package com.capgemini.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookEntity {

    @Id
    private Long id;
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(nullable = false)
    private String authors;

    public BookEntity() {
    }

    public BookEntity(Long id, String title, String authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
