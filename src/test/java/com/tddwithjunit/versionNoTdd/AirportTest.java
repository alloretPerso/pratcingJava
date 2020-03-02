package com.tddwithjunit.versionNoTdd;

import org.junit.jupiter.api.Test;

import static com.tddwithjunit.versionNoTdd.Type.Business;
import static com.tddwithjunit.versionNoTdd.Type.Economy;
import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    @Test
    public void testAirport(){
        Flight economyFlight = new Flight("1", Economy.getName());
        Flight businessFlight = new Flight("2", Business.getName());

        Passenger john = new Passenger("John", true);
        Passenger mike = new Passenger("Mike", false);

        assertEquals(true,economyFlight.addPassenger(john));
        assertEquals(false,economyFlight.removePassenger(john));
        assertEquals(true,businessFlight.addPassenger(john));
        assertEquals(false,businessFlight.removePassenger(john));

        assertEquals(true,economyFlight.addPassenger(mike));
        assertEquals(true,economyFlight.removePassenger(mike));
        assertEquals(false,businessFlight.addPassenger(mike));
        assertEquals(false,businessFlight.removePassenger(mike));
    }

}