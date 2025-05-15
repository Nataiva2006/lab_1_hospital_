package lab_1_hospital;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Hospital {
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void printAllInfo() {
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(d.getInfo());
        }

        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(p.getInfo());
        }
    }
    public List<Doctor> getDoctors() {
        return doctors;
    }
    public List<Patient> getPatients() {
        return patients;
    }

    // JSON експорт / імпорт
    public void exportDoctorsToFile(String filename, Comparator<Doctor> comparator) {
        List<Doctor> sorted = doctors.stream().sorted(comparator).toList();
        ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
        try {
            writer.writeValue(new File(filename), sorted);
            System.out.println("Doctors exported to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importDoctorsFromFile(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Doctor> imported = mapper.readValue(new File(filename), new TypeReference<>() {});
            doctors.addAll(imported);
            System.out.println("Doctors imported from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
