package com.sahan.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahan.departmentservice.dto.DepartmentDTO;
import com.sahan.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {

        DepartmentDTO dto = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<DepartmentDTO>(dto, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartmentbyDepartmentCode(@PathVariable("department-code") String departmentCode) {

        DepartmentDTO dto = departmentService.getDepartmentByCode(departmentCode);

        return new ResponseEntity<DepartmentDTO>(dto, HttpStatus.CREATED);
    }

}
