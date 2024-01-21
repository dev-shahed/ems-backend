package com.ems.ems.service.impl;

import org.springframework.stereotype.Service;

import com.ems.ems.dto.EmployeeDTO;
import com.ems.ems.entity.Employee;
import com.ems.ems.mapper.EmployeeMapper;
import com.ems.ems.repository.EmployeeRepository;
import com.ems.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // first convert employeeDTO into employeeJPA entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

}
