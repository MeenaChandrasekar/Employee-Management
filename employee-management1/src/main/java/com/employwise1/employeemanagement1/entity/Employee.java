package com.employwise1.employeemanagement1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Data
@Document
public class Employee {
    @Id
    private String id;
    private String employeeName;
    private String phoneNumber;
    private String email;
    private String reportsTo;
    private String profileImage;
}
