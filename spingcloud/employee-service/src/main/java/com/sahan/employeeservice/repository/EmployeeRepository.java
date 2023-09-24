package com.sahan.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahan.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
