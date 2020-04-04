package com.workingWithNull;

public class Book {
    private Integer id;
    private Integer authorId;
    private String title;

    private ReadingLevel readingLevel;

    public Book(Integer id, Integer authorId, String title, ReadingLevel readingLevel) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;

        this.readingLevel = readingLevel == null ? NullReadingLevel.getInstance() : readingLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReadingLevel getReadingLevel() {
        return readingLevel;
    }

    public void setReadingLevel(ReadingLevel readingLevel) {
        this.readingLevel = readingLevel;
    }
}
