package com.unitTest.Junit;

import java.time.LocalDateTime;

public class PatientAppointment {
    private final String patientFirstName;
    private final String patientLastName;
    private final LocalDateTime localDateTime;
    private final Doctor doctor;

    public PatientAppointment(String patientFirstName, String patientLastName, LocalDateTime localDateTime, Doctor doctor) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.localDateTime = localDateTime;
        this.doctor = doctor;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
