package com.caroffice.infrastructure.exception;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Enum holding all possible exceptions in the Web Service.
 */
public enum ExceptionEnum {

    OIL_NOT_FOUND(HttpStatus.NOT_FOUND, "OilEntity not found"),
    OIL_CONFLICT(HttpStatus.CONFLICT, "Duplicated OilEntity. Name must be unique");

    private HttpStatus httpStatus;
    private String description;


    ExceptionEnum(HttpStatus httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}