package com.ems.ems.service;

import java.util.List;

import com.ems.ems.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Integer id);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDTO);

    EmployeeDTO deleteEmployee(Integer id);

}
