package com.employwise1.employeemanagement1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.employwise1.employeemanagement1.entity.Employee;
import com.employwise1.employeemanagement1.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String addEmployee(Employee employee) {
        // Generate a unique UUID and save employee to the database
        // ...

        return "GeneratedUUID";
    }

    public List<Employee> getAllEmployees() {
        // Retrieve all employees from the database
        // ...

        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(String id) {
        // Delete employee by ID from the database
        // ...

        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeById(String id, Employee updatedEmployee) {
        // Update employee by ID in the database
        // ...

        return employeeRepository.save(updatedEmployee);
    }

    public String getNthLevelManager(String employeeId, int level) {
        // Implement logic to get nth level manager
        // ...
        return "ManagerID";
    }

    public List<Employee> getPagedAndSortedEmployees(int page, int size, String sortBy) {
        // Get paged and sorted employees
        // ...

        return employeeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy))).getContent();
    }

    public Employee getEmployeeById(String id) {
        // Get employee by ID from the database
        // ...

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    public void sendEmailToLevel1Manager(Employee employee) {
        // Implement logic to send an email to the level 1 manager
        // ...

        // For example:
        String managerEmail = getNthLevelManagerEmail(employee.getReportsTo(), 1);
        String emailContent = generateEmailContent(employee);
        sendEmail(managerEmail, "New Employee Addition", emailContent);
    }

    private String getNthLevelManagerEmail(String employeeId, int level) {
        // Implement logic to get nth level manager's email
        // ...

        return "manager@example.com";
    }

    private String generateEmailContent(Employee employee) {
        return String.format("%s will now work under you. Mobile number is %s and email is %s",
                employee.getEmployeeName(), employee.getPhoneNumber(), employee.getEmail());
    }

    private void sendEmail(String to, String subject, String content) {
        // Implement logic to send an email
        // ...
    }
}
