package com.giusescara.tutorial.springbootcrud.repository;

import com.giusescara.tutorial.springbootcrud.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
