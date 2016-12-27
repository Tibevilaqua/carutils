package com.caroffice.infrastructure.validation;

/**
 * Created by root on 28/12/16.
 */
public class ErrorField {

    private final String name;
    private final String message;


    public ErrorField(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
