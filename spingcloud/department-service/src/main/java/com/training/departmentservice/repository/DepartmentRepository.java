package com.training.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    Department findByDepartmentCode(String departmentCode);
}
