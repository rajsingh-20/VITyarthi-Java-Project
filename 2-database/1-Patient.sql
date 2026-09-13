-- ============================================
-- PATIENTS TABLE
-- ============================================

CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10),
    phone VARCHAR(15),
    address VARCHAR(200),
    disease VARCHAR(100)
);


-- ============================================
-- SAMPLE PATIENTS DATA
-- ============================================

INSERT INTO patients
(name, age, gender, phone, address, disease)
VALUES
('Rahul Sharma', 25, 'Male', '9876543210',
 'Bhopal', 'Fever'),

('Priya Singh', 32, 'Female', '9876543211',
 'Indore', 'Diabetes'),

('Aman Verma', 45, 'Male', '9876543212',
 'Bhopal', 'Blood Pressure');


-- ============================================
-- DISPLAY PATIENT TABLES
-- ============================================

SELECT * FROM patients;
