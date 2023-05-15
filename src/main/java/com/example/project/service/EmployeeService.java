package com.example.project.service;
import com.example.project.dto.EmployeeDTO;
import com.example.project.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeDTO getEmployee(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            EmployeeDTO employeeDTO=new EmployeeDTO();
            BeanUtils.copyProperties(employee,employeeDTO);
            return employeeDTO;
        }
        else {
            return null;
        }
    }

    public EmployeeDTO deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return null;
    }

}
