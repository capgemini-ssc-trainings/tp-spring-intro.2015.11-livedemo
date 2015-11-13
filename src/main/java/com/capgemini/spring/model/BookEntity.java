package com.capgemini.spring.model;

public class BookEntity {

    private Long id;
    private String title;
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
