package lab_1_hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private List<String> appointments;

    public Doctor() {
        this.appointments = new ArrayList<>();
    }

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(String appointment) {
        appointments.add(appointment);
    }

    public String getInfo() {
        return "Doctor: " + name + " (" + specialization + ")";
    }

    // Getters / Setters / equals / hashCode

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
