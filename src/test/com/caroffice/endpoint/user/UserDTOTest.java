package com.caroffice.endpoint.user;

import com.caroffice.entity.UserEntity;
import com.caroffice.infrastructure.user.GenderEnum;
import com.caroffice.infrastructure.utils.AnnotationCheckHelper;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Created by root on 27/12/16.
 */
public class UserDTOTest {

    @Test
    public void shouldReturnUserEntity_when_toEntityMethodIsCalled(){
        Date date = new Date();
        String name = "James";
        String surName = "Bond";
        String email = "james.bond@007.com";
        String password = "123456";

        UserEntity expectedResult = new UserEntity(null, name, surName, GenderEnum.MALE, date, email,password);
        UserDTO toTransform = new UserDTO(name, surName, GenderEnum.MALE, date,email,password);

        Assert.assertEquals("Should be the same", expectedResult, toTransform.toUserEntity());

    }

    @Test
    public void shouldReturnUserEntity_when_toDTOMethodIsCalled(){
        Date date = new Date();
        String name = "James";
        String surName = "Bond";
        String email = "james.bond@007.com";
        String password = "123456";

        UserDTO transformedUserDTO = new UserEntity(null, name, surName, GenderEnum.MALE, date, email,password).toDTO();
        UserDTO expectedResult = new UserDTO(name, surName, GenderEnum.MALE, date,email,password);

        Assert.assertEquals("Should be the same", transformedUserDTO, expectedResult);

    }



    @Test
    public void shouldValidationAnnotationsOnEachAttribute_when_userDTOObjectIsBuilt(){


        Boolean isNotBlankPresentInNameField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "name", NotBlank.class);
        Boolean isLengthPresentInNameField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "name", Length.class);
        Boolean isNotBlankPresentInSurNameField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "surname", NotBlank.class);
        Boolean isLengthPresentInSurNameField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "surname", Length.class);
        Boolean isNotNullPresentInGenderField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "gender", NotNull.class);
        Boolean isNotNullPresentInBirthDateField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "birthDate", NotNull.class);
        Boolean isPastPresentInBirthDateField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "birthDate", Past.class);
        Boolean isNotBlankPresentInEmailField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "email", NotBlank.class);
        Boolean isEmailPresentInEmailField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "email", Email.class);
        Boolean isNotBlankPresentInPasswordField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "password", NotBlank.class);
        Boolean isLengthPresentInPasswordField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "password", Length.class);

        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInNameField);
        assertTrue("Should have @Length to validate itself",isLengthPresentInNameField);
        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInSurNameField);
        assertTrue("Should have @Length to validate itself",isLengthPresentInSurNameField);
        assertTrue("Should have @NotNull to validate itself",isNotNullPresentInGenderField);
        assertTrue("Should have @NotNull to validate itself",isNotNullPresentInBirthDateField);
        assertTrue("Should have @Past to validate itself",isPastPresentInBirthDateField);
        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInEmailField);
        assertTrue("Should have @Email to validate itself",isEmailPresentInEmailField);
        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInPasswordField);
        assertTrue("Should have @Length to validate itself",isLengthPresentInPasswordField);


    }

}
