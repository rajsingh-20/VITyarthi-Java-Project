package model;

public class Bill {

    private int billId;
    private int patientId;
    private double consultationFee;
    private double medicineFee;
    private double roomFee;
    private double totalAmount;
    private String paymentStatus;

    public Bill() {
    }

    public Bill(int patientId, double consultationFee,
                double medicineFee, double roomFee,
                double totalAmount, String paymentStatus) {

        this.patientId = patientId;
        this.consultationFee = consultationFee;
        this.medicineFee = medicineFee;
        this.roomFee = roomFee;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double getMedicineFee() {
        return medicineFee;
    }

    public void setMedicineFee(double medicineFee) {
        this.medicineFee = medicineFee;
    }

    public double getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(double roomFee) {
        this.roomFee = roomFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
