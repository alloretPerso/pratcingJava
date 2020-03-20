package com.lambda2.course2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("files/page1.txt"))) {
            ToIntFunction<String> mapping = word -> {
                System.out.println(word);
                String word_Trim = word.replaceAll("[ ,.-]", "").trim();
                System.out.println(word_Trim);
                return word_Trim.length();
            };
            int sum = lines.mapToInt(mapping)
                    .peek(System.out::println)
                    .parallel()
                    .sum();
            System.out.println("# The value is " + sum);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
