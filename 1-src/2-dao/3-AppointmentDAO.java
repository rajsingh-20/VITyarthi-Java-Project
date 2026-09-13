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

