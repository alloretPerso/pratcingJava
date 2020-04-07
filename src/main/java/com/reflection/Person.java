package com.reflection;


import com.reflection.annotations.Column;
import com.reflection.annotations.PrimaryKey;

public class Person {
    @PrimaryKey
    private long id;
    @Column
    private String name;
    @Column
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static final void aStaticMethod(){
        System.out.println("aStaticMethod");
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
