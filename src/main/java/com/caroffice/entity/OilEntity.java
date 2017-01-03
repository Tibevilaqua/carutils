package com.caroffice.entity;

import com.caroffice.endpoint.oil.OilDTO;
import com.caroffice.entity.behavior.EntityToDTO;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by root on 05/12/16.
 */
@Document(collection = "oil")
public class OilEntity  implements EntityToDTO<OilDTO> {

    @Id
    @Field("_id")
    private ObjectId id;

    private String name;
    private OilTypeEnum type;
    private String description;

    private byte[] image;


    public OilEntity(ObjectId id, String name, OilTypeEnum type, String description, byte[] image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public OilEntity(OilDTO oilDTO) {
        this.name = oilDTO.getName();
        this.description = oilDTO.getDescription();
        this.type = oilDTO.getType();
        this.image = oilDTO.getImage();
    }

    public OilEntity() {
    }


    public OilDTO toDTO(){
        return new OilDTO(this);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public OilTypeEnum getType() {
        return type;
    }


    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(OilTypeEnum type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OilEntity oil = (OilEntity) o;

        if (id != null ? !id.equals(oil.id) : oil.id != null) return false;
        if (name != null ? !name.equals(oil.name) : oil.name != null) return false;
        if (type != oil.type) return false;
        return description != null ? description.equals(oil.description) : oil.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }



}
