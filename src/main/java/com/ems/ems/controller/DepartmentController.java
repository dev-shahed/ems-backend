package com.ems.ems.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ems.ems.dto.DepartmentDTO;
import com.ems.ems.exception.ApiResponse;
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
        try {
            DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdDepartment.getId())
                    .toUri();
            return ResponseEntity.created(location).body(createdDepartment);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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

    @GetMapping("{id}")
    public ResponseEntity<?> gettingDepartmentById(@PathVariable Integer id) {
        try {
            DepartmentDTO department = departmentService.getDepartmentById(id);
            return new ResponseEntity<>(department, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getErrorResponse());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> delettingDepartment(@PathVariable Integer id) {
        try {
            departmentService.deleteDepartment(id);
            return ResponseEntity.ok(new ApiResponse("Department Deleted Successfully."));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("internal server error"));
        }
    }

    // update Department.
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDTO> updatingDepartment(@PathVariable Integer id,
            @RequestBody DepartmentDTO departmentDTO) {
        try {
            DepartmentDTO updatedDep = departmentService.updateDepartment(id, departmentDTO);
            return new ResponseEntity<>(updatedDep, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
