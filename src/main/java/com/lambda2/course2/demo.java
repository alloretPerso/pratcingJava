package com.lambda2.course2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.*;
import static java.util.stream.Collectors.*;

public class demo {
    public static void main(String[] args) {
        try (Stream<String> stream1 = Files.lines(get("files/page1.txt"));
             Stream<String> stream2 = Files.lines(get("files/page2.txt"))) {
           /* System.out.println("Stream 1 : " + stream1.count());
            System.out.println("Stream 2 : " + stream2.count());*/

            Stream<Stream<String>> streamOfStreams = Stream.of(stream1, stream2);
            Stream<String> streamOfLines = streamOfStreams.flatMap(Function.identity());
            Byte test = 2;
            int x = 4;
            int i = x / test;
            int a2[] = {1, 2};

            //System.out.println("#lines " + streamOfLines.count());

            Function<String, Stream<String>> lineSplitter = line -> Pattern.compile(" ").splitAsStream(line);

            Stream<String> streamOfWords = streamOfLines.flatMap(lineSplitter)
                    .map(String::toLowerCase)
                    .filter(word -> word.length() == 4)
                    .distinct();

            System.out.println("# words:" + streamOfWords.count());

        } catch (IOException e) {
            e.printStackTrace();
        }


        average();

        playWithWords();
    }

    private static void average() {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Tom", "Friz"),
                new Person(18, "Tim", "Friz"),
                new Person(60, "Rob", "Friz"),
                new Person(70, "Jef", "Friz")));

        OptionalDouble average = people.stream()
                .mapToInt(Person::getAge)
                .filter(age -> age > 18)
                .average();

        if (average.isPresent()) {
            System.out.println("# the average is : " + average.getAsDouble());
        }
    }

    public static void playWithWords() {

        try {
            Set<String> ospd = Files.lines(get("files/course2/ospd.txt"))
                    .map(String::toLowerCase)
                    .collect(toSet());
            Set<String> shakespeare = Files.lines(get("files/course2/words.shakespeare.txt"))
                    .map(String::toLowerCase)
                    .collect(toSet());

            System.out.println("# Ospd number of words " + ospd.size());
            System.out.println("# Shakespeare number of words " + shakespeare.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
