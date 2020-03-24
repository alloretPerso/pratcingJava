package com.generics.wildcard;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonStorageTest {
    Partner donDraper = new Partner("Don Draper", 89);
    Employee peggyOlson = new Employee("Peggy Olson", 65);
    Partner bertCooper = new Partner("Bert Cooper", 100);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Test
    @Disabled
    public void savesAndLoadsPerson() throws Exception {
        Person person = new Person("Bob", 20);
        saver.save(person);

        assertEquals(null, loader.load());
    }

    @Test
    @Disabled
    public void savesAndLoadsArraysOfPeople() throws Exception {
        List<Partner> people = new ArrayList<>(Arrays.asList(donDraper, bertCooper));
        saver.saveAll(people);

        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @Test
    @Disabled
    public void loadsListsOfPeople() throws Exception {
        saver.save(donDraper);
        saver.save(peggyOlson);

        List<Object> people = new ArrayList<>();

        loader.loadAll(people);
        assertEquals(donDraper,people.get(0));
        assertEquals(peggyOlson,people.get(1));
    }


    static class PersonHolder<T extends Person> {
        T get() {
            return null;
        }
    }
}