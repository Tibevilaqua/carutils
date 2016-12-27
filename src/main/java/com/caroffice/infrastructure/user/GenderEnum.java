package com.caroffice.infrastructure.user;

/**
 * Created by root on 27/12/16.
 */
public enum GenderEnum {

    MALE("Male"),
    FEMALE("Female");

    private String description;


    GenderEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
