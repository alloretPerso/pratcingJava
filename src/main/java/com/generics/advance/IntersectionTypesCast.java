package com.generics.advance;

import java.io.*;

public class IntersectionTypesCast {
    public static void main(String[] args) throws Exception {
        Runnable helloWorld = (Serializable & Runnable)() -> { //Use of intersection
            System.out.println("Hello world");
        };
        helloWorld.run();

        File file = File.createTempFile("runnable", "tmp");
        file.deleteOnExit();
        writeToFile(file,helloWorld);

        final Runnable runnable = (Runnable) readFromFile(file);
        runnable.run();
    }
    public static final void writeToFile(final File file, Object object) throws IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(object);
        }
    }

    public static final Object readFromFile(File file) throws  Exception{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return ois.readObject();
        }
    }
}
