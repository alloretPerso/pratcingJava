package com.tddwithjunit.versionTdd;

public enum Type {

    Economy("Economy"),
    Business("Business");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
