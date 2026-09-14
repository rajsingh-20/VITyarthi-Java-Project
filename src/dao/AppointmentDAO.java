package dao;

import model.Appointment;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentDAO {

    // BOOK APPOINTMENT
    public boolean addAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointments " +
                     "(patient_id, doctor_id, appointment_date, " +
                     "appointment_time, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setTime(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error booking appointment.");
            e.printStackTrace();
            return false;
        }
    }

    // VIEW ALL APPOINTMENTS
    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Appointment a = new Appointment();

                a.setAppointmentId(
                        rs.getInt("appointment_id")
                );

                a.setPatientId(
                        rs.getInt("patient_id")
                );

                a.setDoctorId(
                        rs.getInt("doctor_id")
                );

                a.setAppointmentDate(
                        rs.getDate("appointment_date")
                );

                a.setAppointmentTime(
                        rs.getTime("appointment_time")
                );

                a.setStatus(
                        rs.getString("status")
                );

                appointments.add(a);
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error retrieving appointments."
            );
            e.printStackTrace();
        }

        return appointments;
    }

    // SEARCH APPOINTMENT BY ID
    public Appointment getAppointmentById(int appointmentId) {

        String sql =
                "SELECT * FROM appointments " +
                "WHERE appointment_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Appointment a = new Appointment();

                a.setAppointmentId(
                        rs.getInt("appointment_id")
                );

                a.setPatientId(
                        rs.getInt("patient_id")
                );

                a.setDoctorId(
                        rs.getInt("doctor_id")
                );

                a.setAppointmentDate(
                        rs.getDate("appointment_date")
                );

                a.setAppointmentTime(
                        rs.getTime("appointment_time")
                );

                a.setStatus(
                        rs.getString("status")
                );

                return a;
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error searching appointment."
            );
            e.printStackTrace();
        }

        return null;
    }

    // CANCEL APPOINTMENT
    public boolean cancelAppointment(int appointmentId) {

        String sql =
                "UPDATE appointments " +
                "SET status='Cancelled' " +
                "WHERE appointment_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error cancelling appointment."
            );
            e.printStackTrace();
            return false;
        }
    }
}

