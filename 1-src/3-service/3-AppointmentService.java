package service;

import dao.AppointmentDAO;
import dao.PatientDAO;
import dao.DoctorDAO;
import model.Appointment;
import model.Patient;
import model.Doctor;

import java.util.List;

public class AppointmentService {

    private AppointmentDAO appointmentDAO;
    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;

    public AppointmentService() {
        appointmentDAO = new AppointmentDAO();
        patientDAO = new PatientDAO();
        doctorDAO = new DoctorDAO();
    }

    // Book appointment with validation
    public boolean bookAppointment(Appointment appointment) {

        if (appointment.getPatientId() <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        if (appointment.getDoctorId() <= 0) {
            System.out.println("Invalid doctor ID.");
            return false;
        }

        if (appointment.getAppointmentDate() == null) {
            System.out.println("Appointment date is required.");
            return false;
        }

        if (appointment.getAppointmentTime() == null) {
            System.out.println("Appointment time is required.");
            return false;
        }

        // Check whether patient exists
        Patient patient =
                patientDAO.getPatientById(appointment.getPatientId());

        if (patient == null) {
            System.out.println("Patient not found.");
            return false;
        }

        // Check whether doctor exists
        Doctor doctor =
                doctorDAO.getDoctorById(appointment.getDoctorId());

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return false;
        }

        return appointmentDAO.addAppointment(appointment);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    // Search appointment by ID
    public Appointment getAppointmentById(int appointmentId) {

        if (appointmentId <= 0) {
            System.out.println("Invalid appointment ID.");
            return null;
        }

        return appointmentDAO.getAppointmentById(appointmentId);
    }

    // Cancel appointment
    public boolean cancelAppointment(int appointmentId) {

        if (appointmentId <= 0) {
            System.out.println("Invalid appointment ID.");
            return false;
        }

        Appointment appointment =
                appointmentDAO.getAppointmentById(appointmentId);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return false;
        }

        if (appointment.getStatus().equalsIgnoreCase("Cancelled")) {
            System.out.println("Appointment is already cancelled.");
            return false;
        }

        return appointmentDAO.cancelAppointment(appointmentId);
    }
}

