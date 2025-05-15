package lab_1_hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {
    private int id;
    private String name;
    private List<String> records;

    public Patient() {
        this.records = new ArrayList<>();
    }

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
        this.records = new ArrayList<>();
    }

    public void bookAppointment(Doctor doctor, String dateTime) {
        String appointment = name + " записаний до " + doctor.getName() + " на " + dateTime;
        doctor.addAppointment(appointment);
        records.add(appointment);
    }

    public String getInfo() {
        return "Patient: " + name;
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

    public List<String> getRecords() {
        return records;
    }

    public void setRecords(List<String> records) {
        this.records = records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return id == patient.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
