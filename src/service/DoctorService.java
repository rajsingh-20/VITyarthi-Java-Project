package service;

import dao.DoctorDAO;
import model.Doctor;
import java.util.List;

public class DoctorService {

    private DoctorDAO doctorDAO;

    public DoctorService() {
        doctorDAO = new DoctorDAO();
    }

    // Add doctor with validation
    public boolean addDoctor(Doctor doctor) {

        if (doctor.getName() == null ||
            doctor.getName().trim().isEmpty()) {

            System.out.println("Doctor name cannot be empty.");
            return false;
        }

        if (doctor.getSpecialization() == null ||
            doctor.getSpecialization().trim().isEmpty()) {

            System.out.println("Specialization cannot be empty.");
            return false;
        }

        if (doctor.getExperience() < 0) {
            System.out.println("Invalid experience.");
            return false;
        }

        return doctorDAO.addDoctor(doctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    // Search doctor by ID
    public Doctor getDoctorById(int doctorId) {

        if (doctorId <= 0) {
            System.out.println("Invalid doctor ID.");
            return null;
        }

        return doctorDAO.getDoctorById(doctorId);
    }

    // Update doctor
    public boolean updateDoctor(Doctor doctor) {

        if (doctor.getDoctorId() <= 0) {
            System.out.println("Invalid doctor ID.");
            return false;
        }

        if (doctor.getName() == null ||
            doctor.getName().trim().isEmpty()) {

            System.out.println("Doctor name cannot be empty.");
            return false;
        }

        if (doctor.getExperience() < 0) {
            System.out.println("Invalid experience.");
            return false;
        }

        return doctorDAO.updateDoctor(doctor);
    }

    // Delete doctor
    public boolean deleteDoctor(int doctorId) {

        if (doctorId <= 0) {
            System.out.println("Invalid doctor ID.");
            return false;
        }

        return doctorDAO.deleteDoctor(doctorId);
    }
}
