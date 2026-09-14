import model.Patient;
import model.Doctor;
import model.Appointment;
import model.Bill;

import service.PatientService;
import service.DoctorService;
import service.AppointmentService;
import service.BillService;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static PatientService patientService = new PatientService();
    static DoctorService doctorService = new DoctorService();
    static AppointmentService appointmentService = new AppointmentService();
    static BillService billService = new BillService();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("     HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    appointmentMenu();
                    break;

                case 4:
                    billingMenu();
                    break;

                case 5:
                    System.out.println("Thank you for using Hospital Management System.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    // ================= PATIENT MENU =================

    public static void patientMenu() {

        int choice;

        do {
            System.out.println("\n---------- PATIENT MANAGEMENT ----------");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add Patient
    public static void addPatient() {

        System.out.println("\n--- Add Patient ---");

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        System.out.print("Enter disease: ");
        String disease = sc.nextLine();

        Patient patient = new Patient(
                name, age, gender, phone, address, disease
        );

        if (patientService.addPatient(patient)) {
            System.out.println("Patient added successfully!");
        } else {
            System.out.println("Failed to add patient.");
        }
    }

    // View Patients
    public static void viewPatients() {

        List<Patient> patients =
                patientService.getAllPatients();

        System.out.println("\n--- Patient List ---");

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient p : patients) {

            System.out.println("-------------------------");
            System.out.println("Patient ID : " + p.getPatientId());
            System.out.println("Name       : " + p.getName());
            System.out.println("Age        : " + p.getAge());
            System.out.println("Gender     : " + p.getGender());
            System.out.println("Phone      : " + p.getPhone());
            System.out.println("Address    : " + p.getAddress());
            System.out.println("Disease    : " + p.getDisease());
        }
    }

    // Search Patient
    public static void searchPatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patient p = patientService.getPatientById(id);

        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("\nPatient Details");
        System.out.println("ID       : " + p.getPatientId());
        System.out.println("Name     : " + p.getName());
        System.out.println("Age      : " + p.getAge());
        System.out.println("Gender   : " + p.getGender());
        System.out.println("Phone    : " + p.getPhone());
        System.out.println("Address  : " + p.getAddress());
        System.out.println("Disease  : " + p.getDisease());
    }

    // Update Patient
    public static void updatePatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patient p = patientService.getPatientById(id);

        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter new name: ");
        p.setName(sc.nextLine());

        System.out.print("Enter new age: ");
        p.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter new gender: ");
        p.setGender(sc.nextLine());

        System.out.print("Enter new phone: ");
        p.setPhone(sc.nextLine());

        System.out.print("Enter new address: ");
        p.setAddress(sc.nextLine());

        System.out.print("Enter new disease: ");
        p.setDisease(sc.nextLine());

        if (patientService.updatePatient(p)) {
            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Failed to update patient.");
        }
    }

    // Delete Patient
    public static void deletePatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (patientService.deletePatient(id)) {
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Failed to delete patient.");
        }
    }


    // ================= DOCTOR MENU =================

    public static void doctorMenu() {

        int choice;

        do {
            System.out.println("\n---------- DOCTOR MANAGEMENT ----------");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addDoctor();
                    break;

                case 2:
                    viewDoctors();
                    break;

                case 3:
                    searchDoctor();
                    break;

                case 4:
                    updateDoctor();
                    break;

                case 5:
                    deleteDoctor();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add Doctor
    public static void addDoctor() {

        System.out.println("\n--- Add Doctor ---");

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter experience (years): ");
        int experience = sc.nextInt();
        sc.nextLine();

        Doctor doctor = new Doctor(
                name, specialization, phone, experience
        );

        if (doctorService.addDoctor(doctor)) {
            System.out.println("Doctor added successfully!");
        } else {
            System.out.println("Failed to add doctor.");
        }
    }

    // View Doctors
    public static void viewDoctors() {

        List<Doctor> doctors =
                doctorService.getAllDoctors();

        System.out.println("\n--- Doctor List ---");

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor d : doctors) {

            System.out.println("-------------------------");
            System.out.println("Doctor ID      : " + d.getDoctorId());
            System.out.println("Name           : " + d.getName());
            System.out.println("Specialization : " + d.getSpecialization());
            System.out.println("Phone          : " + d.getPhone());
            System.out.println("Experience     : " + d.getExperience());
        }
    }

    // Search Doctor
    public static void searchDoctor() {

        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Doctor d = doctorService.getDoctorById(id);

        if (d == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.println("\nDoctor Details");
        System.out.println("ID             : " + d.getDoctorId());
        System.out.println("Name           : " + d.getName());
        System.out.println("Specialization : " + d.getSpecialization());
        System.out.println("Phone          : " + d.getPhone());
        System.out.println("Experience     : " + d.getExperience());
    }

    // Update Doctor
    public static void updateDoctor() {

        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Doctor d = doctorService.getDoctorById(id);

        if (d == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Enter new name: ");
        d.setName(sc.nextLine());

        System.out.print("Enter new specialization: ");
        d.setSpecialization(sc.nextLine());

        System.out.print("Enter new phone: ");
        d.setPhone(sc.nextLine());

        System.out.print("Enter new experience: ");
        d.setExperience(sc.nextInt());
        sc.nextLine();

        if (doctorService.updateDoctor(d)) {
            System.out.println("Doctor updated successfully!");
        } else {
            System.out.println("Failed to update doctor.");
        }
    }

    // Delete Doctor
    public static void deleteDoctor() {

        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (doctorService.deleteDoctor(id)) {
            System.out.println("Doctor deleted successfully!");
        } else {
            System.out.println("Failed to delete doctor.");
        }
    }


    // ================= APPOINTMENT MENU =================

    public static void appointmentMenu() {

        int choice;

        do {
            System.out.println("\n---------- APPOINTMENT MANAGEMENT ----------");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Search Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    bookAppointment();
                    break;

                case 2:
                    viewAppointments();
                    break;

                case 3:
                    searchAppointment();
                    break;

                case 4:
                    cancelAppointment();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // Book Appointment
    public static void bookAppointment() {

        System.out.println("\n--- Book Appointment ---");

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter appointment time (HH:MM:SS): ");
        String time = sc.nextLine();

        Appointment appointment = new Appointment(
                patientId,
                doctorId,
                Date.valueOf(date),
                Time.valueOf(time),
                "Scheduled"
        );

        if (appointmentService.bookAppointment(appointment)) {
            System.out.println("Appointment booked successfully!");
        } else {
            System.out.println("Failed to book appointment.");
        }
    }

    // View Appointments
    public static void viewAppointments() {

        List<Appointment> appointments =
                appointmentService.getAllAppointments();

        System.out.println("\n--- Appointment List ---");

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment a : appointments) {

            System.out.println("-------------------------");
            System.out.println("Appointment ID : " + a.getAppointmentId());
            System.out.println("Patient ID     : " + a.getPatientId());
            System.out.println("Doctor ID      : " + a.getDoctorId());
            System.out.println("Date           : " + a.getAppointmentDate());
            System.out.println("Time           : " + a.getAppointmentTime());
            System.out.println("Status         : " + a.getStatus());
        }
    }

    // Search Appointment
    public static void searchAppointment() {

        System.out.print("Enter Appointment ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Appointment a =
                appointmentService.getAppointmentById(id);

        if (a == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.println("\nAppointment Details");
        System.out.println("ID       : " + a.getAppointmentId());
        System.out.println("Patient  : " + a.getPatientId());
        System.out.println("Doctor   : " + a.getDoctorId());
        System.out.println("Date     : " + a.getAppointmentDate());
        System.out.println("Time     : " + a.getAppointmentTime());
        System.out.println("Status   : " + a.getStatus());
    }

    // Cancel Appointment
    public static void cancelAppointment() {

        System.out.print("Enter Appointment ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (appointmentService.cancelAppointment(id)) {
            System.out.println("Appointment cancelled successfully!");
        } else {
            System.out.println("Failed to cancel appointment.");
        }
    }


    // ================= BILLING MENU =================

    public static void billingMenu() {

        int choice;

        do {
            System.out.println("\n---------- BILLING MANAGEMENT ----------");
            System.out.println("1. Generate Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Search Bill");
            System.out.println("4. Update Payment Status");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    generateBill();
                    break;

                case 2:
                    viewBills();
                    break;

                case 3:
                    searchBill();
                    break;

                case 4:
                    updatePaymentStatus();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // Generate Bill
    public static void generateBill() {

        System.out.println("\n--- Generate Bill ---");

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter consultation fee: ");
        double consultationFee = sc.nextDouble();

        System.out.print("Enter medicine fee: ");
        double medicineFee = sc.nextDouble();

        System.out.print("Enter room fee: ");
        double roomFee = sc.nextDouble();

        sc.nextLine();

        Bill bill = new Bill(
                patientId,
                consultationFee,
                medicineFee,
                roomFee,
                0,
                "Pending"
        );

        if (billService.generateBill(bill)) {

            System.out.println("Bill generated successfully!");
            System.out.println("Total Amount: ₹" +
                    bill.getTotalAmount());

        } else {

            System.out.println("Failed to generate bill.");
        }
    }

    // View Bills
    public static void viewBills() {

        List<Bill> bills =
                billService.getAllBills();

        System.out.println("\n--- Bill List ---");

        if (bills.isEmpty()) {
            System.out.println("No bills found.");
            return;
        }

        for (Bill b : bills) {

            System.out.println("-------------------------");
            System.out.println("Bill ID          : " + b.getBillId());
            System.out.println("Patient ID       : " + b.getPatientId());
            System.out.println("Consultation Fee : ₹" +
                    b.getConsultationFee());
            System.out.println("Medicine Fee     : ₹" +
                    b.getMedicineFee());
            System.out.println("Room Fee         : ₹" +
                    b.getRoomFee());
            System.out.println("Total Amount     : ₹" +
                    b.getTotalAmount());
            System.out.println("Payment Status   : " +
                    b.getPaymentStatus());
        }
    }

    // Search Bill
    public static void searchBill() {

        System.out.print("Enter Bill ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Bill b = billService.getBillById(id);

        if (b == null) {
            System.out.println("Bill not found.");
            return;
        }

        System.out.println("\nBill Details");
        System.out.println("Bill ID          : " + b.getBillId());
        System.out.println("Patient ID       : " + b.getPatientId());
        System.out.println("Consultation Fee : ₹" +
                b.getConsultationFee());
        System.out.println("Medicine Fee     : ₹" +
                b.getMedicineFee());
        System.out.println("Room Fee         : ₹" +
                b.getRoomFee());
        System.out.println("Total Amount     : ₹" +
                b.getTotalAmount());
        System.out.println("Payment Status   : " +
                b.getPaymentStatus());
    }

    // Update Payment Status
    public static void updatePaymentStatus() {

        System.out.println("\n--- Update Payment Status ---");

        System.out.print("Enter Bill ID: ");
        int billId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Payment Status (Paid/Pending): ");
        String paymentStatus = sc.nextLine();

        boolean result = billService.updatePaymentStatus(
               billId, paymentStatus
        );

        if (result) {
            System.out.println("Payment status updated successfully!");
        }
        else {
            System.out.println("Failed to update payment status.");
        }
    }
}

