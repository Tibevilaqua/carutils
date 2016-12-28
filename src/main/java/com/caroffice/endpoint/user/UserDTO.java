package com.caroffice.endpoint.user;

import com.caroffice.entity.UserEntity;
import com.caroffice.infrastructure.user.GenderEnum;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

import static com.caroffice.endpoint.user.UserDTOValidationMessages.*;

/**
 * Created by root on 27/12/16.
 */
public class UserDTO {

    @Length(min = 3, message = AT_LEAST_3_CHARACTERS)
    @NotBlank(message = INVALID_NAME)
    private String name;
    @Length(min = 3,  message = AT_LEAST_3_CHARACTERS)
    @NotBlank(message = INVALID_SURNAME)
    private String surname;
    @NotNull(message = INVALID_GENDER)
    private GenderEnum gender;
    @NotNull(message = INVALID_BIRTHDATE)
    @Past(message = "You are not from the future...")
    private Date birthDate;
    @Email(message = INVALID_EMAIL)
    @NotBlank(message = INVALID_EMAIL)
    private String email;
    @Length(min = 3,  message = AT_LEAST_3_CHARACTERS)
    @NotBlank(message = INVALID_PASSWORD)
    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String surname, GenderEnum gender, Date birthDate, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public UserEntity toUserEntity() {
        return new UserEntity(this);
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (name != null ? !name.equals(userDTO.name) : userDTO.name != null) return false;
        if (surname != null ? !surname.equals(userDTO.surname) : userDTO.surname != null) return false;
        if (gender != userDTO.gender) return false;
        if (birthDate != null ? !birthDate.equals(userDTO.birthDate) : userDTO.birthDate != null) return false;
        if (email != null ? !email.equals(userDTO.email) : userDTO.email != null) return false;
        return password != null ? password.equals(userDTO.password) : userDTO.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
