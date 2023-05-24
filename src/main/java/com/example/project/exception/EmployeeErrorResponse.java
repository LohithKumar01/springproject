package com.example.project.exception;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmployeeErrorResponse {
    private int code;
    private String errorMessage;
    private String status;

}
