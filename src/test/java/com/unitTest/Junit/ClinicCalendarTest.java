package com.unitTest.Junit;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {
    @Nested
    @DisplayName("Allow entry of ")
    class allow {
        @Test
        @DisplayName("an appointment")
        public void allowEntryOfAnAppointment() {
            ClinicCalendar calendar = new ClinicCalendar();
            calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00 pm");
            List<PatientAppointment> appointmentList = calendar.getAppointments();
            assertAll(
                    () -> assertNotNull(appointmentList),
                    () -> assertEquals(1, appointmentList.size()),
                    () -> assertEquals("Jim", appointmentList.get(0).getPatientFirstName()),
                    () -> assertEquals("Ralph avery", appointmentList.get(0).getDoctor().getName())
            );
           }

    }
}