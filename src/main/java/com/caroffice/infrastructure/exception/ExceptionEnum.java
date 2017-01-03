package com.caroffice.infrastructure.exception;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Enum holding all possible exceptions in the Web Service.
 */
public enum ExceptionEnum {

    OIL_NOT_FOUND(HttpStatus.NOT_FOUND, "OilEntity not found",null),
    BRAND_NOT_FOUND(HttpStatus.NOT_FOUND, "Brand not found",null),
    MODEL_NOT_FOUND(HttpStatus.NOT_FOUND, "Model not found",null),
    OIL_CONFLICT(HttpStatus.CONFLICT, "Duplicated OilEntity. Name must be unique", "name"),
    USER_EMAIL_CONFLICT(HttpStatus.CONFLICT, "This email is already in use, sorry mate","email");

    private HttpStatus httpStatus;
    private String description;
    private String field;


    ExceptionEnum(HttpStatus httpStatus, String description, String field) {
        this.httpStatus = httpStatus;
        this.description = description;
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getField() {
        return field;
    }
}