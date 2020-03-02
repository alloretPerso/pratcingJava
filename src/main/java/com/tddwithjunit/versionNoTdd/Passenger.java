package com.tddwithjunit.versionNoTdd;

public class Passenger {
    private String name;
    private boolean vip;

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return vip;
    }

    public Passenger(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }
}
