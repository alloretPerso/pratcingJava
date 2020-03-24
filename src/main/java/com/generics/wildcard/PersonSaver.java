package com.generics.wildcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {
    private final RandomAccessFile file;

    public PersonSaver(File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person save(Person person) throws ClassNotFoundException, IOException {
        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeUTF(String.valueOf(person.getAge()));
        return person;
    }

    public void saveAll(List<? extends Person> persons) throws IOException, ClassNotFoundException {
        for (Person person : persons) {
            save(person);
        }
    }
}
