-- ============================================
-- HOSPITAL MANAGEMENT SYSTEM DATABASE
-- ============================================

-- Create Database
CREATE DATABASE hospital_db;

-- Use Database
USE hospital_db;


-- ============================================
-- 4. BILLS TABLE
-- ============================================

CREATE TABLE bills (
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    consultation_fee DECIMAL(10,2),
    medicine_fee DECIMAL(10,2),
    room_fee DECIMAL(10,2),
    total_amount DECIMAL(10,2),
    payment_status VARCHAR(20) DEFAULT 'Pending',

    FOREIGN KEY (patient_id)
        REFERENCES patients(patient_id)
);


-- ============================================
-- SAMPLE BILL DATA
-- ============================================

INSERT INTO bills
(patient_id, consultation_fee, medicine_fee,
 room_fee, total_amount, payment_status)
VALUES
(1, 500.00, 800.00, 1000.00, 2300.00, 'Pending'),

(2, 700.00, 1200.00, 1500.00, 3400.00, 'Paid');


-- ============================================
-- DISPLAY TABLES
-- ============================================

SELECT * FROM bills;
