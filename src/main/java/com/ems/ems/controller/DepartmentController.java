package com.ems.ems.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ems.ems.dto.DepartmentDTO;
import com.ems.ems.exception.ResourceNotFoundException;
import com.ems.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {
    private DepartmentService departmentService;

    /**
     * @param departmentDTO
     * @return created department object.
     */
    @PostMapping()
    public ResponseEntity<DepartmentDTO> creatingDepartment(@RequestBody @Validated DepartmentDTO departmentDTO) {
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDepartment.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdDepartment);
    }

    /**
     * @return all departments
     */
    @GetMapping()
    public ResponseEntity<?> gettingDepartments() {
        try {
            List<DepartmentDTO> allDepList = departmentService.getAllDepartment();
            return new ResponseEntity<>(allDepList, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getErrorResponse(), HttpStatus.NOT_FOUND);
        }
    }
}
