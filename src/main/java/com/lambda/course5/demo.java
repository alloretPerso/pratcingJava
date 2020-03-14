package com.lambda.course5;

import com.lambda.course4.Person;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {
        Stream.empty();
        Stream<String> one = Stream.of("one");
        Stream<String> one1 = Stream.of("one", "two", "three");
        Stream<String> generate = Stream.generate(() -> "one"); // -> use of supplier
        Stream<String> iterate = Stream.iterate("+", s -> s + "+");
        IntStream ints = ThreadLocalRandom.current().ints(); // -> stream of random integer values
        IntStream stream = "hello".chars();
        Stream<String> words = Pattern.compile("[^\\p{javaLetter}]").splitAsStream("fewijfjewpj");
        //Stream<String> lines = Files.lines("/etc/file");

        Stream.Builder<String> builder = Stream.builder();
        builder.add("one").add("two").add("three");
        builder.accept("four");
        Stream<String> build = builder.build();
        //build.forEach(System.out::println); // once consume we cannot add more value to the builder
        //System.out.println("Hello world");



        List<Person> people = new ArrayList<>(Arrays.asList(
                new com.lambda.course4.Person(0, "Tom", "Friz"),
                new com.lambda.course4.Person(18, "Tim", "Friz"),
                new com.lambda.course4.Person(60, "Rob", "Friz"),
                new Person(70, "Jef", "Friz")));

        people.stream()             //Stream<Person>
                .map(Person::getAge) //Stream<Integer>
                .peek(System.out::println)
                .filter(age->age>20) //Stream<Integer>
                .forEach(System.out::println);
    }
}
