package com.lambda.course4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Tom", "Friz"),
                new Person(18, "Tim", "Friz"),
                new Person(60, "Rob", "Friz"),
                new Person(70, "Jef", "Friz")));

        List<Integer> listAge = people.stream().map(Person::getAge).collect(Collectors.toList());

        List<Integer> filteredList = listAge.stream().filter(age -> age > 20).collect(Collectors.toList());

        int sum = filteredList.stream().reduce(Integer::sum).get();

        System.out.println(listAge);
    }
}
