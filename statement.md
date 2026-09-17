# 🏥Hospital Management System

## 1. Problem Statement

Hospitals need to manage a large amount of information related to patients, doctors, appointments, and billing.

Managing these records manually can be time-consuming and may lead to:

- Data duplication
- Difficulty in searching records
- Errors while maintaining information
- Difficulty in tracking appointments
- Manual calculation of bills
- Poor organization of hospital records

Therefore, this project aims to develop a **Java-based Hospital Management System** that provides an organized and computerized way to manage these hospital operations using a relational database.

The system uses **Java, Object-Oriented Programming (OOP), JDBC, and MySQL** to provide a structured solution for managing hospital records.

---

## 2. Scope of the Project

The scope of the Hospital Management System includes the management of basic hospital operations through a console-based Java application.

The system covers the following areas:

### 2.1 Patient Management

The system allows users to:

- Add new patient records
- View all patient records
- Search patients using Patient ID
- Update patient information
- Delete patient records

Patient information includes:

- Patient ID
- Name
- Age
- Gender
- Phone
- Address
- Disease

### 2.2 Doctor Management

The system allows users to:

- Add new doctors
- View all doctors
- Search doctors using Doctor ID
- Update doctor information
- Delete doctor records

Doctor information includes:

- Doctor ID
- Name
- Specialization
- Phone
- Experience

### 2.3 Appointment Management

The system allows users to:

- Book appointments
- View appointments
- Search appointments using Appointment ID
- Cancel appointments

Appointment information includes:

- Appointment ID
- Patient ID
- Doctor ID
- Appointment Date
- Appointment Time
- Status

Before booking an appointment, the system verifies that the selected patient and doctor exist.

### 2.4 Billing Management

The system allows users to:

- Generate patient bills
- Automatically calculate the total bill
- View all bills
- Search bills using Bill ID
- Update payment status

The bill contains:

- Bill ID
- Patient ID
- Consultation Fee
- Medicine Fee
- Room Fee
- Total Amount
- Payment Status

The total amount is calculated as:

```text
Total Amount =
Consultation Fee + Medicine Fee + Room Fee

GitHub Link : https://github.com/rajsingh-20/VITyarthi-Java-Project
