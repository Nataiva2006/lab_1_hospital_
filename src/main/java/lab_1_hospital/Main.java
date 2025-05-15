package lab_1_hospital;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Hospital hospital = new Hospital();
    

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addDoctor();
                case "2" -> addPatient();
                case "3" -> bookAppointment();
                case "4" -> hospital.printAllInfo();
                case "5" -> exportDoctors();
                case "6" -> importDoctors();
                case "0" -> exit = true;
                default -> System.out.println("Невірний вибір. Спробуйте ще.");
            }
        }

        System.out.println("Завершення програми.");
    }

    private static void printMenu() {
        System.out.println("\n--- Меню ---");
        System.out.println("1. Додати лікаря");
        System.out.println("2. Додати пацієнта");
        System.out.println("3. Записати пацієнта на прийом");
        System.out.println("4. Вивести всю інформацію");
        System.out.println("5. Експортувати лікарів у JSON");
        System.out.println("6. Імпортувати лікарів з JSON");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");
    }

    private static void addDoctor() {
        System.out.print("ID лікаря: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ім'я: ");
        String name = scanner.nextLine();
        System.out.print("Спеціалізація: ");
        String spec = scanner.nextLine();

        hospital.addDoctor(new Doctor(id, name, spec));
        System.out.println("Лікаря додано.");
    }

    private static void addPatient() {
        System.out.print("ID пацієнта: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ім'я: ");
        String name = scanner.nextLine();

        hospital.addPatient(new Patient(id, name));
        System.out.println("Пацієнта додано.");
    }

    private static void bookAppointment() {
        System.out.print("ID пацієнта: ");
        int pid = Integer.parseInt(scanner.nextLine());
        System.out.print("ID лікаря: ");
        int did = Integer.parseInt(scanner.nextLine());
        System.out.print("Дата прийому (день.місяць.рік час): ");
        String datetime = scanner.nextLine();

        Patient patient = hospital.getPatients().stream().filter(p -> p.getId() == pid).findFirst().orElse(null);
        Doctor doctor = hospital.getDoctors().stream().filter(d -> d.getId() == did).findFirst().orElse(null);

        if (patient != null && doctor != null) {
            patient.bookAppointment(doctor, datetime);
            System.out.println("Пацієнта записано.");
        } else {
            System.out.println("Лікаря або пацієнта не знайдено.");
        }
    }

    private static void exportDoctors() {
        hospital.exportDoctorsToFile("doctors.json", Comparator.comparing(Doctor::getName));
    }

    private static void importDoctors() {
        hospital.importDoctorsFromFile("doctors.json");
    }
} 
