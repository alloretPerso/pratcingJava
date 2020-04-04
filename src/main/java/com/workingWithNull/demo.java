package com.workingWithNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class demo {
    public static void main(String[] args) {
        //boolean bookReadyForPublication = isBookReadyForPublication(null);

        ReadingLevel rl1 = new NonNullReadingLevel("First grade");

        List<Book> books = new ArrayList<>();

        books.addAll(Arrays.asList(new Book(1, 1, "First title", rl1), new Book(2, 2, null, null)));

/*        for (Book book : books) {
            System.out.println(book.getReadingLevel().getGrade());
        }*/
        List<String> titlesResults = new ArrayList<>();
        books.forEach(book -> {
                    titlesResults.add(book.getTitle() + " - " +
                            book.getReadingLevel()
                                    .map(readingLevel -> readingLevel.getGrade())
                                    .orElse("Not valid value")
                    );

                }
        );
        System.out.println(titlesResults);
    }

    public static boolean isBookReadyForPublication(Integer id) {
        Objects.requireNonNull(id, "Error");
        return true;
    }
}
