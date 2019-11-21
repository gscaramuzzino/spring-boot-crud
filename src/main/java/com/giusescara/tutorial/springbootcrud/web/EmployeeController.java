package com.giusescara.tutorial.springbootcrud.web;

import com.giusescara.tutorial.springbootcrud.exception.RecordNotFoundException;
import com.giusescara.tutorial.springbootcrud.model.EmployeeEntity;
import com.giusescara.tutorial.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = service.getAllEmployees();
        return new ResponseEntity<List<EmployeeEntity>>(employees, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        EmployeeEntity employee = service.getEmployeeById(id);
        return new ResponseEntity<EmployeeEntity>(employee, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee) throws RecordNotFoundException {
        EmployeeEntity employeeUpdated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(employeeUpdated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
}
