# Student Management System

A console-based Student Management System developed using Core Java, JDBC, and MySQL. The application allows users to manage student records through a simple menu-driven interface.

## Features

- Add new student
- View all students
- Search student by ID
- Update student details
- Delete student records
- MySQL database integration
- CRUD operations using JDBC
- PreparedStatement for executing SQL queries

## Technologies Used

- Java
- JDBC
- MySQL
- SQL
- Git & GitHub

## Project Structure

```text
StudentManagementSystem
│
├── lib
│   └── MySQL Connector JAR
│
└── src
    ├── model
    │   └── Student.java
    │
    ├── dao
    │   ├── DatabaseConnection.java
    │   └── StudentDAO.java
    │
    └── main
        └── Main.java
