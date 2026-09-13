  // Delete doctor
    public boolean deleteDoctor(int doctorId) {

        if (doctorId <= 0) {
            System.out.println("Invalid doctor ID.");
            return false;
        }

        return doctorDAO.deleteDoctor(doctorId);
    }
}
