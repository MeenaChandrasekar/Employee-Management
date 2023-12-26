package com.employwise1.employeemanagement1.controller;

import com.employwise1.employeemanagement1.entity.Employee;
import com.employwise1.employeemanagement1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, updatedEmployee));
    }

    @GetMapping("/manager/{employeeId}/{level}")
    public ResponseEntity<String> getNthLevelManager(@PathVariable String employeeId, @PathVariable int level) {
        return ResponseEntity.ok(employeeService.getNthLevelManager(employeeId, level));
    }

    @GetMapping("/paged")
    public ResponseEntity<List<Employee>> getPagedAndSortedEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "employeeName") String sortBy) {
        return ResponseEntity.ok(employeeService.getPagedAndSortedEmployees(page, size, sortBy));
    }

    @PostMapping("/send-email/{id}")
    public ResponseEntity<Void> sendEmailToLevel1Manager(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeById(id);
        employeeService.sendEmailToLevel1Manager(employee);
        return ResponseEntity.noContent().build();
    }
}
