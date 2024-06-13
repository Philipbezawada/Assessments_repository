package Assessment_1_Q1;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    // List to store Student objects
    private List<Student> students;

    // Constructor to initialize the student list
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Method to add a new student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to return all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Method to find a student by their id
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Return null if student not found
    }

    // Method to update details of a student by their id
    public void updateStudent(int id, String name, int age) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
        }
    }

    // Method to remove a student from the list by their id
    public void deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            students.remove(student);
        }
    }
}
