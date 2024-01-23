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

import com.ems.ems.dto.EmployeeDTO;
import com.ems.ems.exception.ApiResponse;
import com.ems.ems.exception.ResourceNotFoundException;
import com.ems.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("")
    public String root() {
        return "Application Running..";
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Validated EmployeeDTO employeeDTO) {
        // Validation is triggered by @Valid annotation on EmployeeDTO
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
        // Return the response with the created employee and location header
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdEmployee);

    }

    @GetMapping("employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        try {
            EmployeeDTO theEmployee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(theEmployee, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorResponse());
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployee() {
        try {
            List<EmployeeDTO> AllEmployees = employeeService.getAllEmployee();
            return new ResponseEntity<>(AllEmployees, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(ex.getErrorResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        try {
            EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);

            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok(new ApiResponse("Employee deleted successfully"));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(ex.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to delete employee"));
        }
    }

}
