package com.workingWithNull.usOfOptional;

public class Book {
    private int numberOfPages;
    private String title;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public Book(int numberOfPages, String title) {
        this.numberOfPages = numberOfPages;
        this.title = title;
    }
}
