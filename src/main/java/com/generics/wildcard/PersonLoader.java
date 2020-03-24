package com.generics.wildcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {
    private final RandomAccessFile file;

    public PersonLoader(File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws ClassNotFoundException {
        try {
            String className = file.readUTF();
            String personName = file.readUTF();
            int age = file.readInt();

            Class<?> personClass = Class.forName(className);
            Constructor<?> constructor = personClass.getConstructor(String.class, Integer.class);
            return (Person) constructor.newInstance(personName, age);
        } catch (IOException e) {
            return null;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    public void loadAll(List<? super Person> people) throws ClassNotFoundException {
        Person person;

        while ((person = load()) != null) {
            people.add(person);
        }
    }
}
