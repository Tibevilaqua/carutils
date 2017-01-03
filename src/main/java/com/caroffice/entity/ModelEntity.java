package com.caroffice.entity;

import com.caroffice.endpoint.model.ModelDTO;
import com.caroffice.entity.behavior.EntityToDTO;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by root on 03/01/17.
 */
@Document(collection = "model")
public class ModelEntity  implements EntityToDTO<ModelDTO> {


    @Id
    @Field("_id")
    private ObjectId id;
    private String name;
    private String brandName;


    public ModelEntity(String name, String brandName) {
        this.name = name;
        this.brandName = brandName;
    }

    public ModelEntity() {
    }

    public ModelDTO toDTO(){
        return new ModelDTO(name,brandName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelEntity that = (ModelEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return brandName != null ? brandName.equals(that.brandName) : that.brandName == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ModelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}