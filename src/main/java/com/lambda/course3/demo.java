package com.lambda.course3;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo {
    private static Map<String, Map<String, Person>> map = new HashMap<>();

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
        Map<String, Person> mapOfPerson = people.stream().collect(Collectors.toMap(Person::getLastName, person -> person));

        map.computeIfAbsent(
                "one",
                key -> new HashMap<>()
        ).put("Kim", new Person(99, "Kim", "Friz"));

        map.values().forEach(System.out::println);
        mergeCheck();
        test1();
        test2();
    }


    private static void mergeCheck() {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Tom", "Friz"),
                new Person(18, "Tim", "Friz"),
                new Person(60, "Rob", "Friz")));
        List<Person> people2 = new ArrayList<>(Arrays.asList(
                new Person(99, "Kim", "Friz")));
        Map<String, List<Person>> map1 = new HashMap<>(Map.of("Value1", people));
        Map<String, List<Person>> map2 = new HashMap<>(Map.of("Value1", people2));

        //V merge (
        //	K key, V newValue, BiFunction< ? Super V,? Super V, ? Extends V > remapping)
        map2.forEach((key, value) -> map1.merge(key, value,
                (existingPeople, newPeople) -> {
                    existingPeople.addAll(newPeople);
                    return existingPeople;
                }));
    }

    private static void test1() {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Tom", "Friz"),
                new Person(18, "Tim", "Friz"),
                new Person(60, "Rob", "Friz"),
                new Person(70, "Jef", "Friz")));
        people.removeIf(person -> person.getAge() < 30);

        people.replaceAll(person -> new Person(person.getAge(), person.getFirstName(), person.getLastName()));

        people.sort(Comparator.comparing(Person::getAge).reversed());

        people.forEach(System.out::println);
    }

    private static void test2() {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Tom", "Friz"),
                new Person(18, "Tim", "Friz"),
                new Person(60, "Rob", "Friz"),
                new Person(70, "Jef", "Friz")));

        List<City> cities = new ArrayList<>(Arrays.asList(
                new City("HongKong"),
                new City("Paris"),
                new City("London")
        ));

        Map<City, List<Person>> map = new HashMap<>();

        System.out.println("People from paris: " + map.getOrDefault(cities.get(1), Collections.EMPTY_LIST));
    }


}
