package com.ems.ems.service;
import java.util.List;

import com.ems.ems.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(int id);
    List<EmployeeDTO> getAllEmployee();
}
