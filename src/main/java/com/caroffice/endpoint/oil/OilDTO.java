package com.caroffice.endpoint.oil;

import com.caroffice.entity.OilEntity;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Arrays;


/**
 * Created by root on 05/12/16.
 */
public class OilDTO {

    @NotBlank(message = "Invalid name")
    private String name;

    @NotNull(message = "invalid type")
    private OilTypeEnum type;

    @NotBlank(message = "Invalid description")
    private String description;

    private byte[] image;


    public OilDTO() {
    }

    public OilDTO(String name, OilTypeEnum type, String description, byte[] image) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public OilDTO(OilEntity oilEntity) {
        this.name = oilEntity.getName();
        this.type = oilEntity.getType();
        this.description = oilEntity.getDescription();
        this.image = oilEntity.getImage();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OilTypeEnum getType() {
        return type;
    }

    public void setType(OilTypeEnum type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OilEntity toOilEntity(){
        return new OilEntity(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OilDTO oilDTO = (OilDTO) o;

        if (name != null ? !name.equals(oilDTO.name) : oilDTO.name != null) return false;
        if (type != oilDTO.type) return false;
        return description != null ? description.equals(oilDTO.description) : oilDTO.description == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "OilDTO{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
