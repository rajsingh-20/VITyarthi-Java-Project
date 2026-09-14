package service;

import dao.BillDAO;
import dao.PatientDAO;
import model.Bill;
import model.Patient;
import java.util.List;

public class BillService {

    private BillDAO billDAO;
    private PatientDAO patientDAO;

    public BillService() {
        billDAO = new BillDAO();
        patientDAO = new PatientDAO();
    }

    // Generate bill with validation
    public boolean generateBill(Bill bill) {

        if (bill.getPatientId() <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        // Check whether patient exists
        Patient patient =
                patientDAO.getPatientById(bill.getPatientId());

        if (patient == null) {
            System.out.println("Patient not found.");
            return false;
        }

        // Validate fees
        if (bill.getConsultationFee() < 0 ||
            bill.getMedicineFee() < 0 ||
            bill.getRoomFee() < 0) {

            System.out.println("Fees cannot be negative.");
            return false;
        }

        // Calculate total amount
        double total =
                bill.getConsultationFee()
                + bill.getMedicineFee()
                + bill.getRoomFee();

        bill.setTotalAmount(total);

        // Set default payment status
        if (bill.getPaymentStatus() == null ||
            bill.getPaymentStatus().trim().isEmpty()) {

            bill.setPaymentStatus("Pending");
        }

        return billDAO.addBill(bill);
    }

    // Get all bills
    public List<Bill> getAllBills() {
        return billDAO.getAllBills();
    }

    // Search bill by ID
    public Bill getBillById(int billId) {

        if (billId <= 0) {
            System.out.println("Invalid bill ID.");
            return null;
        }

        return billDAO.getBillById(billId);
    }

    // Update payment status
    public boolean updatePaymentStatus(int billId, String paymentStatus) {

        if (billId <= 0) {
            System.out.println("Invalid bill ID.");
            return false;
        }

        if (paymentStatus == null ||
            paymentStatus.trim().isEmpty()) {

            System.out.println("Payment status cannot be empty.");
            return false;
        }

        // Check whether bill exists
        Bill bill = billDAO.getBillById(billId);

        if (bill == null) {
            System.out.println("Bill not found.");
            return false;
        }

        return billDAO.updatePaymentStatus(billId, paymentStatus);
    }
}
