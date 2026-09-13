```java
package service;

import dao.PatientDAO;
import model.Patient;

import java.util.List;

public class PatientService {

    private PatientDAO patientDAO;

    public PatientService() {
        patientDAO = new PatientDAO();
    }

    // ADD PATIENT
    public boolean addPatient(Patient patient) {

        if (patient.getName() == null ||
            patient.getName().trim().isEmpty()) {

            System.out.println("Patient name cannot be empty.");
            return false;
        }

        if (patient.getAge() <= 0) {

            System.out.println("Invalid age.");
            return false;
        }

        if (patient.getPhone() == null ||
            patient.getPhone().length() < 10) {

            System.out.println("Invalid phone number.");
            return false;
        }

        return patientDAO.addPatient(patient);
    }

    // VIEW ALL PATIENTS
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    // SEARCH PATIENT
    public Patient getPatientById(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return null;
        }

        return patientDAO.getPatientById(patientId);
    }

    // UPDATE PATIENT
    public boolean updatePatient(Patient patient) {

        if (patient.getPatientId() <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        if (patient.getName() == null ||
            patient.getName().trim().isEmpty()) {

            System.out.println("Patient name cannot be empty.");
            return false;
        }

        if (patient.getAge() <= 0) {
            System.out.println("Invalid age.");
            return false;
        }

        return patientDAO.updatePatient(patient);
    }

    // DELETE PATIENT
    public boolean deletePatient(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return false;
        }

        return patientDAO.deletePatient(patientId);
    }
}
```

            System.out.println(
                    "Payment status cannot be empty."
            );

            return false;
        }

        Bill bill = billDAO.getBillById(billId);

        if (bill == null) {
            System.out.println("Bill not found.");
            return false;
        }

        return billDAO.updatePaymentStatus(
                billId,
                paymentStatus
        );
    }
}
```

---

## Your complete `service` folder

```text id="7kqf9x"
service/
│
├── PatientService.java
├── DoctorService.java
├── AppointmentService.java
└── BillingService.java
```

And the overall project now looks like:

```text id="3o5j7m"
HospitalManagementSystem/
│
├── src/
│   │
│   ├── model/
│   │   ├── Patient.java
│   │   ├── Doctor.java
│   │   ├── Appointment.java
│   │   └── Bill.java
│   │
│   ├── dao/
│   │   ├── PatientDAO.java
│   │   ├── DoctorDAO.java
│   │   ├── AppointmentDAO.java
│   │   └── BillDAO.java
│   │
│   ├── service/
│   │   ├── PatientService.java
│   │   ├── DoctorService.java
│   │   ├── AppointmentService.java
│   │   └── BillingService.java
│   │
│   ├── util/
│   │   └── DatabaseConnection.java
│   │
│   └── Main.java
│
├── database/
│   └── hospital.sql
│
├── README.md
└── statement.md
```

### The important concept here

Your application now follows a clean **3-layer architecture**:

```text
        Main.java
            ↓
     Service Layer
            ↓
        DAO Layer
            ↓
       MySQL Database
```

For example, when adding a patient:

```text
User
 ↓
Main.java
 ↓
PatientService
 ↓
PatientDAO
 ↓
JDBC
 ↓
MySQL
```

This separation is useful for your project's **modular implementation, architecture, documentation, and maintainability**, which are explicitly part of the project expectations.

**Next, the most important part is `Main.java`** — we'll create the actual menu-driven application that lets the user operate all four modules from one program.

