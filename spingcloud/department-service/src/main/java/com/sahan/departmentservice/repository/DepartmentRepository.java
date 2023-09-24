package com.sahan.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahan.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    Department findByDepartmentCode(String departmentCode);
}
