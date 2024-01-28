package com.ems.ems.service;

import java.util.List;

import com.ems.ems.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartment();

    DepartmentDTO getDepartmentById(Long id);

    DepartmentDTO deleteDepartment(Long id);

    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);
}
