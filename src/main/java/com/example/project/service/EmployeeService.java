package com.example.project.service;
import com.example.project.dto.EmployeeDTO;
import com.example.project.entity.Employee;
import com.example.project.exception.EmployeeException;
import com.example.project.exception.EmployeeExceptionEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeDTO getEmployee(int id){
        Optional<Employee> employeeOptional = employeeRepository.findById((int) id);
        if (employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            EmployeeDTO employeeDTO=new EmployeeDTO();
            BeanUtils.copyProperties(employee,employeeDTO);
            return employeeDTO;
        }
        else {
            throw new EmployeeException(EmployeeExceptionEnum.BAD_REQUEST);

        }
    }

    public String deleteEmployee(Integer id){
        employeeRepository.deleteById((Integer) id);
        return "Success";
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee();
        newEmployee.setName(employeeDTO.getName());
        newEmployee.setAge(employeeDTO.getAge());
        newEmployee.setCity(employeeDTO.getCity());
        newEmployee.setSalary(employeeDTO.getSalary());
        newEmployee.setDesignation(employeeDTO.getDesignation());

        Employee savedEmployee = employeeRepository.save(newEmployee);
        BeanUtils.copyProperties(savedEmployee,employeeDTO);
        return employeeDTO;
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getId());
        if (!optionalEmployee.isPresent()){
            return null;
        }
        Employee employee = optionalEmployee.get();
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setCity(employeeDTO.getCity());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDesignation(employeeDTO.getDesignation());

        Employee savedEmployee = employeeRepository.save(employee);
        BeanUtils.copyProperties(savedEmployee,employeeDTO);
        return employeeDTO;
    }
}