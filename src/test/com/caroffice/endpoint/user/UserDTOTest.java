package com.caroffice.endpoint.user;

import com.caroffice.endpoint.oil.OilDTO;
import com.caroffice.entity.UserEntity;
import com.caroffice.infrastructure.user.GenderEnum;
import com.caroffice.infrastructure.utils.AnnotationCheckHelper;
import org.hibernate.validator.constraints.NotBlank;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.Arrays;
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

        UserEntity expectedResult = new UserEntity(null, name, surName, GenderEnum.MALE, date);
        UserDTO toTransform = new UserDTO(name, surName, GenderEnum.MALE, date);

        Assert.assertEquals("Should be the same", expectedResult, toTransform.toUserEntity());

    }


    @Test
    public void shouldValidationAnnotationsOnEachAttribute_when_userDTOObjectIsBuilt(){


        Boolean isNotBlankPresentInNameField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "name", NotBlank.class);
        Boolean isNotBlankPresentInSurNameField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "surname", NotBlank.class);
        Boolean isNotNullPresentInGenderField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "gender", NotNull.class);
        Boolean isNotNullPresentInBirthDateField = AnnotationCheckHelper.doesFieldContainsAnnotation(UserDTO.class, "birthDate", NotNull.class);

        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInNameField);
        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInSurNameField);
        assertTrue("Should have @NotNull to validate itself",isNotNullPresentInGenderField);
        assertTrue("Should have @NotNull to validate itself",isNotNullPresentInBirthDateField);


    }

}
