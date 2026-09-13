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
```

