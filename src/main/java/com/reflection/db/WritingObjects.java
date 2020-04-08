package com.reflection.db;

import com.reflection.Person;
import com.reflection.annotations.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class WritingObjects {
    public static void main(String[] args) throws IllegalAccessException, SQLException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        EntityManager<Person> entityManager = EntityManager.of(Person.class);
/*        Person linda = new Person("Linda",31);
        Person james = new Person("James", 24);
        Person susan = new Person("Susan",34);
        Person jhon = new Person("Jhon", 33);
        System.out.println(linda);
*//*        entityManager.persist(linda);
        entityManager.persist(james);
        entityManager.persist(susan);
        entityManager.persist(jhon);*//*
        System.out.println(linda);*/

        Person linda = entityManager.find(Person.class, 1L);
        Person james = entityManager.find(Person.class, 2L);
        Person susan = entityManager.find(Person.class, 3L);
        Person jhon = entityManager.find(Person.class, 4L);

        System.out.println(linda);

    }
}
