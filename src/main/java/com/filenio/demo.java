package com.filenio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;


public class demo {
    public static void main(String[] args) {
        Path path = Path.of("src/main/java/com/filenio/sample/sample.txt");
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path);) {
                String line = reader.readLine();
                while (line != null) {

                    System.out.println("Line = " + line);
                    line = reader.readLine();
                }
                int a = new Random().nextInt(5);
                int b = new Random().nextInt(5);
                int c = new Random().nextInt(5);
                int val = a > c || b > c ?  (a > b) ? a : b : c;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
