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

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department theDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department doesn't exist!"));
        return DepartmentMapper.mapToDepartmentDTO(theDepartment);
    }

    @Override
    public DepartmentDTO deleteDepartment(Long id) {
        Department theDep = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department doesn't exist!"));
        departmentRepository.deleteById(id);
        return DepartmentMapper.mapToDepartmentDTO(theDep);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department theDep = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department doesn't exist!"));
        if (theDep != null) {
            theDep.setName(departmentDTO.getName());
            theDep.setDescription(departmentDTO.getDescription());
        }
        departmentRepository.save(theDep);
        return DepartmentMapper.mapToDepartmentDTO(theDep);
    }

}
