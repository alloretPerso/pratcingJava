package com.corelearnings.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class AdderBis implements Callable {
    private String inFile, outFile;

    public AdderBis(String inFile) {
        this.inFile = inFile;
    }

    public final int doAdd() throws IOException {
        int total = 0;
        String line;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while ((line = reader.readLine()) != null) {
                total += line.length();
            }
        }
        return total;
    }

    @Override
    public Integer call() throws IOException {
            return doAdd();
    }
}
