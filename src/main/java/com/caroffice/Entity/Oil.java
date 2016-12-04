package com.caroffice.Entity;

import com.caroffice.infrastructure.oil.OilType;

/**
 * Created by root on 05/12/16.
 */
public class Oil {

    private Integer id;
    private String name;
    private OilType type;
    private String description;

    public Oil(Integer id, String name, OilType type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Oil() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OilType getType() {
        return type;
    }

    public void setType(OilType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
