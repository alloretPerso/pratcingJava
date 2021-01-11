package com.annotation;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person person) {
        int compare = name.compareTo(person.name);
        return compare != 0 ? compare : person.age - age;
    }

    @Override
    public String toString() {
        return name;
    }
}
