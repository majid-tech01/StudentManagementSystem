package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student student) {

        String sql =
                "INSERT INTO students (name, age, course, marks) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getCourse());
            statement.setDouble(4, student.getMarks());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Failed to add student.");
            e.printStackTrace();
        }
    }


    // VIEW ALL STUDENTS
    public void viewAllStudents() {

        String sql = "SELECT * FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n===== ALL STUDENTS =====");

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                System.out.println(
                        "ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Age: " + resultSet.getInt("age") +
                        ", Course: " + resultSet.getString("course") +
                        ", Marks: " + resultSet.getDouble("marks")
                );
            }

            if (!found) {
                System.out.println("No students found.");
            }

        } catch (SQLException e) {
            System.out.println("Failed to fetch students.");
            e.printStackTrace();
        }
    }


    // SEARCH STUDENT BY ID
    public void searchStudent(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                System.out.println("\n===== STUDENT FOUND =====");

                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Course: " + resultSet.getString("course"));
                System.out.println("Marks: " + resultSet.getDouble("marks"));

            } else {

                System.out.println("Student not found.");

            }

        } catch (SQLException e) {
            System.out.println("Failed to search student.");
            e.printStackTrace();
        }
    }


    // UPDATE STUDENT
    public void updateStudent(Student student) {

        String sql =
                "UPDATE students SET name = ?, age = ?, course = ?, marks = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getCourse());
            statement.setDouble(4, student.getMarks());
            statement.setInt(5, student.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Failed to update student.");
            e.printStackTrace();
        }
    }


    // DELETE STUDENT
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Failed to delete student.");
            e.printStackTrace();
        }
    }
}