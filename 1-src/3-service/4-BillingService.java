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

