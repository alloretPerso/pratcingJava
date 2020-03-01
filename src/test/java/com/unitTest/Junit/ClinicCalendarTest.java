package com.unitTest.Junit;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClinicCalendarTest {

    @Test
    public void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00 pm");
        List<PatientAppointment> appointmentList = calendar.getAppointments();
        assertNotNull(appointmentList);
        assertEquals(1, appointmentList.size());
    }

}