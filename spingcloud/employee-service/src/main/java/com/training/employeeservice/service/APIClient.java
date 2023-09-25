package com.training.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.employeeservice.dto.DepartmentDTO;

// @FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERCVICE")
public interface APIClient {

    @GetMapping("api/departments/{department-code}")
    DepartmentDTO getDepartmentbyDepartmentCode(@PathVariable("department-code") String departmentCode);
    
}
