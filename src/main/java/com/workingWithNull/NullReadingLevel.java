package com.workingWithNull;

public class NullReadingLevel extends ReadingLevel {
    private static NullReadingLevel instance = new NullReadingLevel();

    private NullReadingLevel() {
        setGrade("N/A");
    }

    public static NullReadingLevel getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Null value";
    }
}
