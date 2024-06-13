package com.techm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to add a new employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Method to return all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Method to find an employee by their id
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    // Method to update details of an employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Method to remove an employee from the database by their id
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
