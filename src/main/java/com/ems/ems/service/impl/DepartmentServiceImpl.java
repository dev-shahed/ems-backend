package com.ems.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.ems.dto.DepartmentDTO;
import com.ems.ems.entity.Department;
import com.ems.ems.exception.ResourceNotFoundException;
import com.ems.ems.mapper.DepartmentMapper;
import com.ems.ems.repository.DepartmentRepository;
import com.ems.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    // TODO: implement methods of the interface, add validation and error handling
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);
        departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        if (departments.isEmpty()) {
            throw new ResourceNotFoundException("No department exists!");
        }
        return departments.stream().map(DepartmentMapper::mapToDepartmentDTO).collect(Collectors.toList());
    }

}
