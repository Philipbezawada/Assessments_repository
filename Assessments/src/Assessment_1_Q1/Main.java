package Assessment_1_Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Display menu and perform CRUD operations based on user choice
        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new student
                	System.out.println("");
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    Student student = new Student(id, name, age);
                    studentManager.addStudent(student);
                    System.out.println("Student added successfully.");
                    System.out.println("---------------------------------------");
                    System.out.println("");
                    break;
                case 2:
                    // View all students
                	System.out.println("");
                    System.out.println("List of all students:");
                    for (Student s : studentManager.getAllStudents()) {
                        System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge());
                        System.out.println("---------------------------------------");
                        System.out.println("");
                    }
                    break;
                case 3:
                    // Find student by ID
                	System.out.println("");
                    System.out.print("Enter student ID: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = studentManager.getStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("ID: " + foundStudent.getId() + ", Name: " + foundStudent.getName() + ", Age: " + foundStudent.getAge());
                    } else {
                        System.out.println("Student not found.");
                    }
                    System.out.println("---------------------------------------");
                    System.out.println("");
                    break;
                case 4:
                    // Update student details
                	System.out.println("");
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    studentManager.updateStudent(updateId, newName, newAge);
                    System.out.println("Student updated successfully.");
                    System.out.println("---------------------------------------");
                    System.out.println("");
                    break;
                    
                case 5:
                    // Delete student by ID
                	System.out.println("");
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentManager.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully.");
                    System.out.println("---------------------------------------");
                    System.out.println("");
                    break;
                case 6:
                    // Exit
                    System.out.println("----------Exiting the system-------------.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("---------------------------------------");
                    System.out.println("");
            }
        } while (choice != 6);

        scanner.close();
    }
}
