```java
package dao;

import model.Doctor;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // ADD DOCTOR
    public boolean addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors " +
                     "(name, specialization, phone, experience) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getExperience());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding doctor.");
            e.printStackTrace();
            return false;
        }
    }

    // VIEW ALL DOCTORS
    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Doctor d = new Doctor();

                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(
                        rs.getString("specialization")
                );
                d.setPhone(rs.getString("phone"));
                d.setExperience(
                        rs.getInt("experience")
                );

                doctors.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving doctors.");
            e.printStackTrace();
        }

        return doctors;
    }

    // SEARCH DOCTOR BY ID
    public Doctor getDoctorById(int doctorId) {

        String sql = "SELECT * FROM doctors WHERE doctor_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Doctor d = new Doctor();

                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(
                        rs.getString("specialization")
                );
                d.setPhone(rs.getString("phone"));
                d.setExperience(
                        rs.getInt("experience")
                );

                return d;
            }

        } catch (SQLException e) {
            System.out.println("Error searching doctor.");
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE DOCTOR
    public boolean updateDoctor(Doctor doctor) {

        String sql = "UPDATE doctors SET " +
                     "name=?, specialization=?, phone=?, " +
                     "experience=? WHERE doctor_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getExperience());
            ps.setInt(5, doctor.getDoctorId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating doctor.");
            e.printStackTrace();
            return false;
        }
    }

    // DELETE DOCTOR
    public boolean deleteDoctor(int doctorId) {

        String sql = "DELETE FROM doctors WHERE doctor_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting doctor.");
            e.printStackTrace();
            return false;
        }
    }
}
```

