package com.training.employeeservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.employeeservice.dto.APIResponseDTO;
import com.training.employeeservice.dto.DepartmentDTO;
import com.training.employeeservice.dto.EmployeeDTO;
import com.training.employeeservice.entity.Employee;
import com.training.employeeservice.exception.ResourceNotFoundException;
import com.training.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    // @Autowired
    // private RestTemplate restTemplate;

    // @Autowired
    // private WebClient webClient;

    @Autowired
    private APIClient apiClient;


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

    public APIResponseDTO getEmployeebyId(Long employeeId) throws Exception {

       Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Emloyee" ,"id", employeeId));

       DepartmentDTO departmentDTO = apiClient.getDepartmentbyDepartmentCode(employee.getDepartmentCode());
     
    //    DepartmentDTO departmentDTO = webClient.get().uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDTO.class).block();
    //    ResponseEntity<DepartmentDTO> departmentResponse = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDTO.class);

        APIResponseDTO apiResponseDTO = new APIResponseDTO(modelMapper.map(employee, EmployeeDTO.class), departmentDTO);

        return apiResponseDTO;

    }

}
