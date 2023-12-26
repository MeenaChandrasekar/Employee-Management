package com.employwise1.employeemanagement1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://localhost";
    }

    @Override
    public String getUserName() {
        return "yourUsername";
    }

    @Override
    public String getPassword() {
        return "yourPassword";
    }

    @Override
    public String getBucketName() {
        return "Meena";  // Replace with your actual bucket name
    }
}
