package com.caroffice.infrastructure.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ErrorField> errors = new ArrayList<>();

    private final String errorMessage;

    public ValidationErrorDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void addValidationError(ErrorField error) {
        errors.add(error);
    }

    public List<ErrorField> getErrors() {
        return errors;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}