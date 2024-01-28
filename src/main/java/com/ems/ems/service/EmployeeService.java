package com.ems.ems.service;

import java.util.List;

import com.ems.ems.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    EmployeeDTO deleteEmployee(Long id);

}
