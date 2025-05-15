package lab_1_hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {
    private Hospital hospital;
    private Doctor doctor1;
    private Patient patient1;

    @BeforeEach
    void setUp() {
        hospital = new Hospital();
        doctor1 = new Doctor(1, "Іван", "Хірург");
        patient1 = new Patient(101, "Олег");
    }

    @Test
    void testAddDoctor() {
        hospital.addDoctor(doctor1);
        assertEquals(1, hospital.getDoctors().size());
        assertEquals("Іван", hospital.getDoctors().get(0).getName());
    }

    @Test
    void testAddPatient() {
        hospital.addPatient(patient1);
        assertEquals(1, hospital.getPatients().size());
    }

    @Test
    void testDoctorAddAppointment() {
        doctor1.addAppointment("Олег записаний на 15.05");
        List<String> appointments = doctor1.getAppointments();
        assertTrue(appointments.contains("Олег записаний на 15.05"));
    }

    @Test
    void testPatientBookAppointment() {
        patient1.bookAppointment(doctor1, "16.05.2025 10:00");
        assertEquals(1, patient1.getRecords().size());
        assertEquals(1, doctor1.getAppointments().size());
    }

    @Test
    void testDoctorEqualsAndHash() {
        Doctor doctor2 = new Doctor(1, "Інше ім'я", "Інша спец.");
        assertEquals(doctor1, doctor2);
        assertEquals(doctor1.hashCode(), doctor2.hashCode());
    }

    @Test
    void testPatientEqualsDifferentId() {
        Patient other = new Patient(102, "Олег");
        assertNotEquals(patient1, other);
    }

    @Test
    void testSetAndGetDoctorFields() {
        doctor1.setName("Нове ім'я");
        doctor1.setSpecialization("Терапевт");
        assertEquals("Нове ім'я", doctor1.getName());
        assertEquals("Терапевт", doctor1.getSpecialization());
    }

    @Test
    void testNullDoctorAppointmentsHandling() {
        Doctor doctor = new Doctor();
        doctor.setAppointments(null);
        assertThrows(NullPointerException.class, () -> doctor.addAppointment("Some text"));
    }

    @Test
    void testInvalidInputPatientBooking() {
        Patient patient = new Patient();
        Doctor doctor = new Doctor();
        assertDoesNotThrow(() -> patient.bookAppointment(doctor, ""));
        assertEquals(1, patient.getRecords().size());
    }
}