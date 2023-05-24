package com.example.project.exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmployeeException extends RuntimeException{
    private EmployeeExceptionEnum employeeExceptionEnum;
    private HttpStatus httpStatus;


    public EmployeeException(EmployeeExceptionEnum employeeExceptionEnum) {
        this.employeeExceptionEnum = employeeExceptionEnum;

    }

    public EmployeeException(String message, EmployeeExceptionEnum employeeExceptionEnum, HttpStatus httpStatus) {
        super(message);
        this.employeeExceptionEnum = employeeExceptionEnum;
        this.httpStatus = httpStatus;
    }
}

