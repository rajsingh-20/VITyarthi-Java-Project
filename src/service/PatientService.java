package service;

import dao.PatientDAO;
import model.Patient;
import java.util.List;

public class PatientService {

    private PatientDAO patientDAO;

    public PatientService() {
        patientDAO = new PatientDAO();
    }

    // Add patient with validation
    public boolean addPatient(Patient patient) {

        if (patient.getName() == null ||
            patient.getName().trim().isEmpty()) {

            System.out.println("Patient name cannot be empty.");
            return false;
        }

        if (patient.getAge() <= 0) {
            System.out.println("Invalid age.");
            return false;
        }

        if (patient.getPhone() == null ||
            patient.getPhone().length() < 10) {

            System.out.println("Invalid phone number.");
            return false;
        }

        return patientDAO.addPatient(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    // Search patient by ID
    public Patient getPatientById(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return null;
        }

        return patientDAO.getPatientById(patientId);
    }

    // Update patient
    public boolean updatePatient(Patient patient) {

        if (patient.getPatientId() <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        if (patient.getName() == null ||
            patient.getName().trim().isEmpty()) {

            System.out.println("Patient name cannot be empty.");
            return false;
        }

        if (patient.getAge() <= 0) {
            System.out.println("Invalid age.");
            return false;
        }

        return patientDAO.updatePatient(patient);
    }

    // Delete patient
    public boolean deletePatient(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        return patientDAO.deletePatient(patientId);
    }
}
