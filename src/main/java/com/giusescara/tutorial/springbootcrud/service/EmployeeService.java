package com.giusescara.tutorial.springbootcrud.service;

import com.giusescara.tutorial.springbootcrud.exception.RecordNotFoundException;
import com.giusescara.tutorial.springbootcrud.model.EmployeeEntity;
import com.giusescara.tutorial.springbootcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employeeList = repository.findAll();
        if (!employeeList.isEmpty()) return employeeList;
        else return new ArrayList<EmployeeEntity>();
    }

    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = repository.findById(id);
        if (employee.isPresent()) return employee.get();
        else throw new RecordNotFoundException("No employee record exist for given id");
    }

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = repository.findById(entity.getId());
        if (!employee.isPresent()) {
            EmployeeEntity newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            entity = newEntity;
        }
        return repository.save(entity);
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = repository.findById(id);
        if (employee.isPresent()) repository.deleteById(id);
        else throw new RecordNotFoundException("No employee record exist for given id");
    }

}
