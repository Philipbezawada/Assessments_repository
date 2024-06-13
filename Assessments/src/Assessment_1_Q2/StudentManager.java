package Assessment_1_Q2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private Connection connection;

    // Constructor to establish a database connection
    public StudentManager(String jdbcUrl, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(jdbcUrl, username, password);
    }

    // Method to add a new student to the database
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO Students (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.executeUpdate();
        }
    }

    // Method to return all students
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(id, name, age));
            }
        }
        return students;
    }

    // Method to find a student by their id
    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT * FROM Students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    return new Student(id, name, age);
                }
            }
        }
        return null; // Return null if student not found
    }

    // Method to update details of a student by their id
    public void updateStudent(int id, String name, int age) throws SQLException {
        String query = "UPDATE Students SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    // Method to remove a student from the database by their id
    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM Students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Method to close the database connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
