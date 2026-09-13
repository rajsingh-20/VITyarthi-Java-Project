-- ============================================
-- APPOINTMENTS TABLE
-- ============================================

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status VARCHAR(20) DEFAULT 'Scheduled',

    FOREIGN KEY (patient_id)
        REFERENCES patients(patient_id),

    FOREIGN KEY (doctor_id)
        REFERENCES doctors(doctor_id)
);


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
-- DISPLAY APPOINTMENTS TABLES
-- ============================================

SELECT * FROM appointments;
