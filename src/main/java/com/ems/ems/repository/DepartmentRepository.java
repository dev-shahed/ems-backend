package com.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
