package com.training.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
