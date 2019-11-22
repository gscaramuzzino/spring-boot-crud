package com.giusescara.tutorial.springbootcrud.service;

import com.giusescara.tutorial.springbootcrud.model.EmployeeEntity;
import com.giusescara.tutorial.springbootcrud.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class TestEmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Test
    public void getAllEmployees() {
        List<EmployeeEntity> employees = repository.findAll();
        Assert.isNull(employees, "The employees list is not null");

    }

}
