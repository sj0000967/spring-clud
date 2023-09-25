package com.training.departmentservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.departmentservice.dto.DepartmentDTO;
import com.training.departmentservice.entity.Department;
import com.training.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDTO saveDepartment(DepartmentDTO dto) {

        Department department = modelMapper.map(dto, Department.class);
        Department savedDepartment = departmentRepository.save(department);

        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public List<DepartmentDTO> getDepartments() {

        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(department -> modelMapper
                .map(department, DepartmentDTO.class)).collect(Collectors.toList());

    }

    public DepartmentDTO getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return modelMapper.map(department, DepartmentDTO.class);

    }

}
