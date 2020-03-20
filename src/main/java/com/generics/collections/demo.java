package com.generics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        Person[] madMen = {donDraper, peggyOlson};

        //System.out.println(Arrays.toString(madMen));

        Person bertCooper = new Person("Bert Cooper", 100);
        //madMen = add(bertCooper, madMen);
        //System.out.println(Arrays.toString(madMen));

        List<Person> madMenList = new ArrayList<>(Arrays.asList(madMen));
        madMenList.add(bertCooper);
        System.out.println(madMenList);
    }

    private static Person[] add(Person person, Person[] madMen) {

        Person[] people = Arrays.copyOf(madMen, madMen.length + 1);
        people[madMen.length] = person;
        return people;

    }
}
