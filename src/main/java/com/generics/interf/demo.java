package com.generics.interf;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.addAll(Arrays.asList(donDraper, peggyOlson, bertCooper));
        System.out.println(madMen);
        Collections.sort(madMen, new AgeComparator());
        System.out.println(madMen);
        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
        System.out.println(madMen);
    }
}
