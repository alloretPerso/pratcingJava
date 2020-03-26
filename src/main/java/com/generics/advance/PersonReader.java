package com.generics.advance;

import java.io.*;

public class PersonReader {
    public static void main(String[] args) throws FileNotFoundException {
        PersonReader reader = new PersonReader();
        DataInputStream stream = new DataInputStream(new FileInputStream("src/main/resources/person"));
        Person person = reader.reader(stream);
        System.out.println(person);

        RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/person","rw");
        person = reader.reader(randomAccessFile);
        System.out.println(person);
    }

    private <T extends DataInput & Closeable> Person reader(T source) {
        try (T input = source) {
            return new Person(input.readUTF(), input.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
