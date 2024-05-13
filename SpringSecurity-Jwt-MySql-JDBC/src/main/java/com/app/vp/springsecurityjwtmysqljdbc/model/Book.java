package com.app.vp.springsecurityjwtmysqljdbc.model;

public class Book {

    private Long id;
    private String author;

    public Book(Long id, String author) {
        this.id = id;
        this.author = author;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                '}';
    }
}
