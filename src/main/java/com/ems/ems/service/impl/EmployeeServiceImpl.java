package com.ems.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.ems.dto.EmployeeDTO;
import com.ems.ems.entity.Employee;
import com.ems.ems.exception.ResourceNotFoundException;
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
        // first convert employeeDTO into employeeJPA entity..
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        Employee theEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with the given id: " + id));
        return EmployeeMapper.mapToEmployeeDTO(theEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found.");
        }
        // return employees.stream().map((employee) ->
        // EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
        return employees.stream().map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with the given id: " + id));
        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
    }

}
