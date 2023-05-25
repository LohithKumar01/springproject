package com.example.project.exception;

import org.springframework.http.HttpStatus;
public enum EmployeeExceptionEnum {
    BAD_REQUEST(7000, "Invalid request", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(7777,"Internal server error",HttpStatus.INTERNAL_SERVER_ERROR),
    OK(7002,"Success",HttpStatus.OK);

    EmployeeExceptionEnum(Integer code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    private Integer code;
    private String message;
    private HttpStatus httpStatus;

    public static boolean isException() {
        return false;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
