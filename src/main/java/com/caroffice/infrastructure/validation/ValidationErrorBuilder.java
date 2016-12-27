package com.caroffice.infrastructure.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ValidationErrorBuilder {

    public static ValidationErrorDTO fromBindingErrors(Errors errors) {
        ValidationErrorDTO error = new ValidationErrorDTO("Validation failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {

            String field = ((FieldError) objectError).getField();
            error.addValidationError(String.format("%s%s%s", "Invalid ", field, " value"));

        }
        return error;
    }

    public static ValidationErrorDTO fromBindingErrors(String field, String value) {
        ValidationErrorDTO error = new ValidationErrorDTO("Validation failed, incompatible value. 1 error");
        error.addValidationError(String.format("%s%s", "Field:" , field));
        error.addValidationError(String.format("%s%s", "Value:" , value));
        return error;
    }

    public static ValidationErrorDTO bodyNotSent() {
        ValidationErrorDTO error = new ValidationErrorDTO("Validation failed, incompatible value. 1 error");
        error.addValidationError(String.format("Required request body is missing"));
        return error;
    }
}