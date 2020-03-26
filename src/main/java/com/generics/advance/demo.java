package com.generics.advance;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class demo {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Predicate<Person> isOld = person -> person.getAge() > 80;

        System.out.println(isOld.test(donDraper));
        System.out.println(isOld.test(peggyOlson));

        List<Person> people = new ArrayList<>(Arrays.asList(donDraper, peggyOlson, bertCooper));
        Map<Boolean, List<Person>> oldAndYoungPeople = people.stream()
                .collect(partitioningBy(isOld));
        System.out.println(oldAndYoungPeople);
        Map<Boolean, Long> oldAndYoungPeopleSize = people.stream()
                .collect(partitioningBy(isOld, counting()));
        System.out.println(oldAndYoungPeopleSize);
    }
}
