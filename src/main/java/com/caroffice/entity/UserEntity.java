package com.caroffice.entity;

import com.caroffice.endpoint.user.UserDTO;
import com.caroffice.infrastructure.user.GenderEnum;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by root on 27/12/16.
 */
@Document(collection = "user")
public class UserEntity {


    @Id
    @Field("_id")
    private ObjectId id;

    private String name;
    private String surname;
    private GenderEnum gender;
    private Date birthDate;
    private String email;
    private String password;

    public UserEntity() {
    }

    public UserEntity(ObjectId id, String name, String surname, GenderEnum gender, Date birthDate, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public UserEntity(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.gender = userDTO.getGender();
        this.birthDate = userDTO.getBirthDate();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (gender != that.gender) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
