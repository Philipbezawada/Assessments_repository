package com.techm;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeManager {
    private JdbcTemplate jdbcTemplate;

    // Constructor to initialize JdbcTemplate
    public EmployeeManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to add a new employee to the database
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employees (name, department) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());
    }

    // Method to return all employees
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    // Method to find an employee by their id
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    // Method to update details of an employee
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employees SET name = ?, department = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
    }

    // Method to remove an employee from the database by their id
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Inner class for mapping ResultSet to Employee objects
    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
        }
    }
}
