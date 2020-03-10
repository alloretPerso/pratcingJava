package com.lambda.course3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(0, "Tom", "Friz"),
                new Person(18, "Tim", "Friz"),
                new Person(60, "Rob", "Friz"));
        people.forEach(System.out::println);

        //people.removeIf(person -> person.getAge() < 20);
        List<String> names = people.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        names.replaceAll(String::toLowerCase);
        names.forEach(System.out::println);

    }
}
