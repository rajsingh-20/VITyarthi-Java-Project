-- ============================================
-- HOSPITAL MANAGEMENT SYSTEM DATABASE
-- ============================================

-- Create Database
CREATE DATABASE hospital_db;

-- Use Database
USE hospital_db;


-- ============================================
-- 2. DOCTORS TABLE
-- ============================================

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100),
    phone VARCHAR(15),
    experience INT
);


-- ============================================
-- SAMPLE DOCTOR DATA
-- ============================================

INSERT INTO doctors
(name, specialization, phone, experience)
VALUES
('Dr. Amit Kumar', 'Cardiologist', '9876500001', 10),

('Dr. Neha Sharma', 'Dermatologist', '9876500002', 7),

('Dr. Raj Mehta', 'General Physician', '9876500003', 5);


-- ============================================
-- SAMPLE APPOINTMENT DATA
-- ============================================

INSERT INTO appointments
(patient_id, doctor_id, appointment_date,
 appointment_time, status)
VALUES
(1, 3, '2026-09-15', '10:00:00', 'Scheduled'),

(2, 2, '2026-09-16', '11:30:00', 'Scheduled');


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

SELECT * FROM patients;

SELECT * FROM doctors;

SELECT * FROM appointments;

SELECT * FROM bills;
