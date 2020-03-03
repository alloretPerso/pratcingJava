package com.tddwithjunit.versionTdd;

import java.util.*;

public abstract class Flight {
    private String id;
    protected Set<Passenger> passengerList = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengerList() {
        return Collections.unmodifiableSet(passengerList);
    }


    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}

