package com.ems.ems.mapper;

import com.ems.ems.dto.EmployeeDTO;
import com.ems.ems.entity.Employee;

//Mapping JPA to DTO and DTO to JPA..
public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(),
                employeeDTO.getEmail());
    }
}
