package com.capgemini.spring.model;

public class BookEntity {

    private String title;
    private String authors;

    public BookEntity(String title, String authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }
}
