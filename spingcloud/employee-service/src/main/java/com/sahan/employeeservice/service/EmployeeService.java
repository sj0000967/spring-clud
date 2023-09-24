package com.sahan.employeeservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahan.employeeservice.dto.EmployeeDTO;
import com.sahan.employeeservice.entity.Employee;
import com.sahan.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO saveEmployee(EmployeeDTO dto) {

        Employee employee = modelMapper.map(dto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> modelMapper
                .map(employee, EmployeeDTO.class)).collect(Collectors.toList());

    }

    public EmployeeDTO getEmployeebyId(Long employeeId) throws Exception {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new Exception("Eployee not found"));

        return modelMapper.map(employee, EmployeeDTO.class);

    }

}
