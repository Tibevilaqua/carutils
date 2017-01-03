package com.caroffice.endpoint.brand;

import com.caroffice.entity.BrandEntity;

import java.util.Arrays;

/**
 * Created by root on 03/01/17.
 */
public class BrandDTO {

    private String name;
    private byte[] image;

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public BrandDTO(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public BrandDTO(BrandEntity brandEntity) {
        this.name = brandEntity.getName();
        this.image = brandEntity.getImage();

    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandDTO brandDTO = (BrandDTO) o;

        return name != null ? name.equals(brandDTO.name) : brandDTO.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
