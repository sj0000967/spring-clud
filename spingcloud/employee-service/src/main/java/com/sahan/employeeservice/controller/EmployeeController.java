package com.sahan.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahan.employeeservice.dto.EmployeeDTO;
import com.sahan.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        return new ResponseEntity<EmployeeDTO>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById (@PathVariable("employee-id") Long employeeId) throws Exception {

        return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeebyId(employeeId), HttpStatus.OK);

    }
    
}
