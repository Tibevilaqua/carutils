package com.caroffice.endpoint.model;

/**
 * Created by root on 03/01/17.
 */
public class ModelDTO {


    private String name;
    private String brandName;

    public ModelDTO(String name, String brandName){
        this.name = name;
        this.brandName = brandName;
    }


    public ModelDTO() {
    }


    public String getName() {
        return name;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelDTO modelDTO = (ModelDTO) o;

        if (name != null ? !name.equals(modelDTO.name) : modelDTO.name != null) return false;
        return brandName != null ? brandName.equals(modelDTO.brandName) : modelDTO.brandName == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ModelDTO{" +
                "name='" + name + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
