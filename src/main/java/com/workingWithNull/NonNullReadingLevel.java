package com.workingWithNull;

public class NonNullReadingLevel extends ReadingLevel {
    public NonNullReadingLevel(String grade) {
        setGrade(grade);
    }

    @Override
    public String toString() {
        return "NonNullReadingLevel "+ getGrade();
    }
}
