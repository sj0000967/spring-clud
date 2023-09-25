package com.training.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String departmentCode;
}
