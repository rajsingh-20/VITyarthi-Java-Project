# 🐍VITyarthi-Java-Project
## 🏥Hospital Management System

A Java-based Hospital Management System designed to manage essential hospital operations such as patient records, doctor information, appointments, and billing.

The project is developed using **Java, Object-Oriented Programming (OOP), JDBC, and MySQL**. It follows a layered architecture with separate Model, DAO, Service, Utility, and Main components.

---

## 👤 Student Details

| Field | Details |
|-------|---------|
| **Name** | Raj Singh |
| **Registration No.** | 25BAI10997 |
| **Branch** | CSE (AI & ML) |
| **Year** | Second Year B.Tech |
| **Course Code** | CSE2006 |
| **Course Title** | Programming in Java |
| **Credits** | 3 Credit – Graded Course |
| **University** | VIT Bhopal University |
| **Submission Date** | 18th September 2026 |

---

## 🗂️ Repository Structure

```
main/
│
├── 1-src/
│   │
│   ├── 1-model/
│   │   ├── 1-Patient.java
│   │   ├── 2-Doctor.java
│   │   ├── 3-Appointment.java
│   │   └── 4-Bill.java
│   │
│   ├── 2-dao/
│   │   ├── 1-PatientDAO.java
│   │   ├── 2-DoctorDAO.java
│   │   ├── 3-AppointmentDAO.java
│   │   └── 4-BillDAO.java
│   │
│   ├── 3-service/
│   │   ├── 1-PatientService.java
│   │   ├── 2-DoctorService.java
│   │   ├── 3-AppointmentService.java
│   │   └── 4-BillingService.java
│   │
│   ├── 4-util/
│   │   ├── 1-DatabaseConnection.java
│   │   └── 2-InputValidator.java
│   │
│   └── Main.java
│
├── 2-database/
│   ├── 0-Database.sql
│   ├── 1-Patient.sql
│   ├── 2-Doctor.sql
│   ├── 3-Appointment.sql
│   ├── 4-Bill.sql
│
├── README.md
└── statement.md
```

---

## 📝1. Project Overview

Managing hospital information manually can be time-consuming and can lead to errors in maintaining patient records, doctor information, appointments, and billing details.

The **Hospital Management System** provides a structured computerized solution for these activities.

The system allows users to:

- Add and manage patient records
- Add and manage doctor records
- Book and cancel appointments
- View appointment details
- Generate patient bills
- Update payment status
- Search records using unique IDs
- Store information in a MySQL database

The application uses **JDBC (Java Database Connectivity)** to communicate between the Java application and MySQL database.

---

## 🔴2. Problem Statement

Hospitals need to maintain a large amount of information related to patients, doctors, appointments, and billing.

Managing these records manually can result in:

- Data duplication
- Difficulty in searching records
- Errors in maintaining information
- Difficulty in tracking appointments
- Manual calculation of bills
- Poor organization of hospital records

Therefore, this project aims to develop a **Java-based Hospital Management System** that provides an organized way to manage these operations using a relational database.

---

## 3. Objectives

The main objectives of this project are:

1. To develop a computerized hospital management system using Java.
2. To apply Object-Oriented Programming concepts in a practical project.
3. To store hospital data using a MySQL relational database.
4. To connect Java with MySQL using JDBC.
5. To provide separate modules for patients, doctors, appointments, and billing.
6. To implement validation and error handling.
7. To reduce manual data management.
8. To provide a simple and easy-to-use console-based interface.
9. To maintain a modular and maintainable project structure.
10. To demonstrate database operations such as INSERT, SELECT, UPDATE, and DELETE.

---

## 4. Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Application development |
| OOP | Object-oriented design |
| JDBC | Java-MySQL connectivity |
| MySQL | Database management |
| SQL | Database operations |
| VS Code / IntelliJ IDEA / Eclipse | Development environment |
| Git | Version control |
| GitHub | Source code hosting |

---

## 5. Major Functional Modules

The system contains four major functional modules.

### 5.1 Patient Management

The Patient Management module handles patient information.

#### Features

- Add new patient
- View all patients
- Search patient by ID
- Update patient information
- Delete patient

#### Patient Information

- Patient ID
- Name
- Age
- Gender
- Phone
- Address
- Disease

---

### 5.2 Doctor Management

The Doctor Management module maintains doctor information.

#### Features

- Add doctor
- View all doctors
- Search doctor by ID
- Update doctor information
- Delete doctor

#### Doctor Information

- Doctor ID
- Name
- Specialization
- Phone
- Experience

---

### 5.3 Appointment Management

The Appointment Management module handles appointments between patients and doctors.

#### Features

- Book appointment
- View all appointments
- Search appointment by ID
- Cancel appointment

#### Appointment Information

- Appointment ID
- Patient ID
- Doctor ID
- Appointment Date
- Appointment Time
- Status

Before booking an appointment, the system checks whether the specified patient and doctor exist.

---

### 5.4 Billing Management

The Billing Management module handles patient billing.

#### Features

- Generate bill
- Automatically calculate total amount
- View all bills
- Search bill by ID
- Update payment status

#### Billing Information

- Bill ID
- Patient ID
- Consultation Fee
- Medicine Fee
- Room Fee
- Total Amount
- Payment Status

The total bill is calculated using:

```text
Total Amount =
Consultation Fee + Medicine Fee + Room Fee
