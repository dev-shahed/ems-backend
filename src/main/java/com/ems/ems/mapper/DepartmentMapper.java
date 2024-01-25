package com.ems.ems.mapper;

import com.ems.ems.dto.DepartmentDTO;
import com.ems.ems.entity.Department;

public class DepartmentMapper {
    // Map Department JPA to DTO and DTO to JPA..
    public static DepartmentDTO mapToDepartmentDTO(Department department) {
        return new DepartmentDTO(department.getId(), department.getName(), department.getDescription());
    }

    // Map Department DTO to JPA..
    public static Department mapToDepartment(DepartmentDTO departmentDTO) {
        return new Department(departmentDTO.getId(), departmentDTO.getName(), departmentDTO.getDescription());
    }
}
