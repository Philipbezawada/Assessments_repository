package com.techm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeManager employeeManager = context.getBean(EmployeeManager.class);
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Display menu and perform CRUD operations based on user choice
        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new employee
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee department: ");
                    String department = scanner.next();
                    Employee employee = new Employee(0, name, department);
                    employeeManager.addEmployee(employee);
                    System.out.println("Employee added successfully.");
                    break;
                case 2:
                    // View all employees
                    System.out.println("List of all employees:");
                    for (Employee emp : employeeManager.getAllEmployees()) {
                        System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Department: " + emp.getDepartment());
                    }
                    break;
                case 3:
                    // Find employee by ID
                    System.out.print("Enter employee ID: ");
                    int searchId = scanner.nextInt();
                    Employee foundEmployee = employeeManager.getEmployeeById(searchId);
                    if (foundEmployee != null) {
                        System.out.println("ID: " + foundEmployee.getId() + ", Name: " + foundEmployee.getName() + ", Department: " + foundEmployee.getDepartment());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    // Update employee details
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new department: ");
                    String newDepartment = scanner.next();
                    Employee updatedEmployee = new Employee(updateId, newName, newDepartment);
                    employeeManager.updateEmployee(updatedEmployee);
                    System.out.println("Employee updated successfully.");
                    break;
                case 5:
                    // Delete employee by ID
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    employeeManager.deleteEmployee(deleteId);
                    System.out.println("Employee deleted successfully.");
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
