package com.workingWithNull.usOfOptional;

import java.util.Optional;

public class demo {
    public static void main(String[] args) {
        Book book = new Book(600, "Short story");

        if (book != null && book.getNumberOfPages() > 500) {
            System.out.println("work");
        }
        Optional<Book> bookOptional = Optional.ofNullable(book);
        bookOptional.filter(book1 -> book1.getNumberOfPages() > 500)
                .ifPresent(
                        book1 -> System.out.println("Work")
                );

        String title = "";
        if (book != null) {
            title = book.getTitle();
        }

        title = bookOptional.map(book1 -> book1.getTitle())
                .orElse("");
        System.out.println(title);


    }
}
