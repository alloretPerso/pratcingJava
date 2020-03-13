package com.lambda.course4;

public class Person {
    private int age;
    private String lastName;
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person(int age, String lastName, String firstName) {
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
