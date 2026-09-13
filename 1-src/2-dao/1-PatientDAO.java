```java
package dao;

import model.Patient;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // ADD PATIENT
    public boolean addPatient(Patient patient) {

        String sql = "INSERT INTO patients " +
                     "(name, age, gender, phone, address, disease) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getDisease());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding patient.");
            e.printStackTrace();
            return false;
        }
    }

    // VIEW ALL PATIENTS
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Patient p = new Patient();

                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setPhone(rs.getString("phone"));
                p.setAddress(rs.getString("address"));
                p.setDisease(rs.getString("disease"));

                patients.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving patients.");
            e.printStackTrace();
        }

        return patients;
    }

    // SEARCH PATIENT BY ID
    public Patient getPatientById(int patientId) {

        String sql = "SELECT * FROM patients WHERE patient_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Patient p = new Patient();

                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setPhone(rs.getString("phone"));
                p.setAddress(rs.getString("address"));
                p.setDisease(rs.getString("disease"));

                return p;
            }

        } catch (SQLException e) {
            System.out.println("Error searching patient.");
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE PATIENT
    public boolean updatePatient(Patient patient) {

        String sql = "UPDATE patients SET " +
                     "name=?, age=?, gender=?, phone=?, " +
                     "address=?, disease=? " +
                     "WHERE patient_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getDisease());
            ps.setInt(7, patient.getPatientId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating patient.");
            e.printStackTrace();
            return false;
        }
    }

    ```java
package dao;

import model.Patient;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // ADD PATIENT
    public boolean addPatient(Patient patient) {

        String sql = "INSERT INTO patients " +
                     "(name, age, gender, phone, address, disease) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getDisease());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding patient.");
            e.printStackTrace();
            return false;
        }
    }

    // VIEW ALL PATIENTS
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Patient p = new Patient();

                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setPhone(rs.getString("phone"));
                p.setAddress(rs.getString("address"));
                p.setDisease(rs.getString("disease"));

                patients.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving patients.");
            e.printStackTrace();
        }

        return patients;
    }

    // SEARCH PATIENT BY ID
    public Patient getPatientById(int patientId) {

        String sql = "SELECT * FROM patients WHERE patient_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Patient p = new Patient();

                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setPhone(rs.getString("phone"));
                p.setAddress(rs.getString("address"));
                p.setDisease(rs.getString("disease"));

                return p;
            }

        } catch (SQLException e) {
            System.out.println("Error searching patient.");
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE PATIENT
    public boolean updatePatient(Patient patient) {

        String sql = "UPDATE patients SET " +
                     "name=?, age=?, gender=?, phone=?, " +
                     "address=?, disease=? " +
                     "WHERE patient_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getDisease());
            ps.setInt(7, patient.getPatientId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating patient.");
            e.printStackTrace();
            return false;
        }
    }

    
