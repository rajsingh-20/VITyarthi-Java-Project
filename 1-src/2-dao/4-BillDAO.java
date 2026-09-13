```java
package dao;

import model.Bill;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    // ADD / GENERATE BILL
    public boolean addBill(Bill bill) {

        String sql = "INSERT INTO bills " +
                     "(patient_id, consultation_fee, medicine_fee, " +
                     "room_fee, total_amount, payment_status) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getPatientId());
            ps.setDouble(2, bill.getConsultationFee());
            ps.setDouble(3, bill.getMedicineFee());
            ps.setDouble(4, bill.getRoomFee());
            ps.setDouble(5, bill.getTotalAmount());
            ps.setString(6, bill.getPaymentStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error generating bill.");
            e.printStackTrace();
            return false;
        }
    }

    // VIEW ALL BILLS
    public List<Bill> getAllBills() {

        List<Bill> bills = new ArrayList<>();

        String sql = "SELECT * FROM bills";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Bill b = new Bill();

                b.setBillId(
                        rs.getInt("bill_id")
                );

                b.setPatientId(
                        rs.getInt("patient_id")
                );

                b.setConsultationFee(
                        rs.getDouble("consultation_fee")
                );

                b.setMedicineFee(
                        rs.getDouble("medicine_fee")
                );

                b.setRoomFee(
                        rs.getDouble("room_fee")
                );

                b.setTotalAmount(
                        rs.getDouble("total_amount")
                );

                b.setPaymentStatus(
                        rs.getString("payment_status")
                );

                bills.add(b);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving bills.");
            e.printStackTrace();
        }

        return bills;
    }

    // SEARCH BILL BY ID
    public Bill getBillById(int billId) {

        String sql =
                "SELECT * FROM bills WHERE bill_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Bill b = new Bill();

                b.setBillId(
                        rs.getInt("bill_id")
                );

                b.setPatientId(
                        rs.getInt("patient_id")
                );

                b.setConsultationFee(
                        rs.getDouble("consultation_fee")
                );

                b.setMedicineFee(
                        rs.getDouble("medicine_fee")
                );

                b.setRoomFee(
                        rs.getDouble("room_fee")
                );

                b.setTotalAmount(
                        rs.getDouble("total_amount")
                );

                b.setPaymentStatus(
                        rs.getString("payment_status")
                );

                return b;
            }

        } catch (SQLException e) {
            System.out.println("Error searching bill.");
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE PAYMENT STATUS
    public boolean updatePaymentStatus(
            int billId, String paymentStatus) {

        String sql =
                "UPDATE bills SET payment_status=? " +
                "WHERE bill_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, paymentStatus);
            ps.setInt(2, billId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(
                    "Error updating payment status."
            );
            e.printStackTrace();
            return false;
        }
    }
}
```


