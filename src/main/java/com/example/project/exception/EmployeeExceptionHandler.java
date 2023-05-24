package com.example.project.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleInternalException(Exception exception, WebRequest webRequest){
        EmployeeErrorResponse employeeErrorResponse=new EmployeeErrorResponse();
        employeeErrorResponse.setErrorMessage(exception.getMessage());
        employeeErrorResponse.setCode(EmployeeExceptionEnum.INTERNAL_SERVER_ERROR.getCode());
        employeeErrorResponse.setStatus("FAILED");
        return handleExceptionInternal(exception,employeeErrorResponse,new HttpHeaders(),EmployeeExceptionEnum.INTERNAL_SERVER_ERROR.getHttpStatus(),webRequest);
    }
    @ExceptionHandler(value = {EmployeeException.class})
    protected ResponseEntity<Object> handleEmployeeException(EmployeeException employeeException, WebRequest webRequest){
        EmployeeErrorResponse employeeErrorResponse=new EmployeeErrorResponse();
        employeeErrorResponse.setErrorMessage(employeeException.getEmployeeExceptionEnum().getMessage());
        employeeErrorResponse.setCode(employeeException.getEmployeeExceptionEnum().getCode());
        employeeErrorResponse.setStatus("FAILED");
        return handleExceptionInternal(employeeException,employeeErrorResponse,new HttpHeaders(),employeeException.getEmployeeExceptionEnum().getHttpStatus(),webRequest);
    }


}
