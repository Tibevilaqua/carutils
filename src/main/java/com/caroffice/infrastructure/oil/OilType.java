package com.caroffice.infrastructure.oil;

/**
 * Created by root on 05/12/16.
 */
public enum OilType {

    TYPE_5W_30("5W-30");

    String type;


    OilType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
