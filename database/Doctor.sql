-- ============================================
-- DOCTORS TABLE
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
-- DISPLAY DOCTORS TABLE
-- ============================================

SELECT * FROM doctors;
