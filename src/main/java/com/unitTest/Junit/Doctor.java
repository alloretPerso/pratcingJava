package com.unitTest.Junit;

public enum Doctor {

    avery("Ralph avery"),
    johnson("Beth johnson"),
    murphy("Pat murphy");

    private String name;

    Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
