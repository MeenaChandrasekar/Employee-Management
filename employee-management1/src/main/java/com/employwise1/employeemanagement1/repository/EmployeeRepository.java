package com.employwise1.employeemanagement1.repository;

import com.employwise1.employeemanagement1.entity.Employee;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface EmployeeRepository extends CouchbaseRepository<Employee, String> {
}
