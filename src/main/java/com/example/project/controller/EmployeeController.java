package com.example.project.controller;

import com.example.project.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.project.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public EmployeeDTO getEmployee(@RequestParam("id")Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
        return employeeDTO;
    }


    @DeleteMapping
    public EmployeeDTO deleteEmployee(@RequestParam("id")Long employeeId){
        EmployeeDTO employeeDTO=employeeService.deleteEmployee(employeeId);
        return employeeDTO;
    }

}
