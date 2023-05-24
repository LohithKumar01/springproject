package com.example.project.controller;

import com.example.project.dto.EmployeeDTO;
import com.example.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable int employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
        return employeeDTO;
    }
    @DeleteMapping
    public String deleteEmployee(@RequestParam("id")int employeeId){
        String status=employeeService.deleteEmployee(employeeId);
        return status;
    }
    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO createEmployeeDTO=employeeService.createEmployee(employeeDTO);
        return createEmployeeDTO;
    }
    @PutMapping
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO updateEmployeeDTO=employeeService.updateEmployee(employeeDTO);
        return updateEmployeeDTO;
    }
}
