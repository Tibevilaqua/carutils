package com.caroffice.endpoint.oil;

import com.caroffice.entity.OilEntity;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import com.caroffice.infrastructure.utils.AnnotationCheckHelper;
import org.hibernate.validator.constraints.NotBlank;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.NotNull;

import static org.junit.Assert.assertTrue;

/**
 * Created by root on 27/12/16.
 */
public class OilDTOTest {


    @Test
    public void shouldReturnOilEntity_when_toEntityMethodIsCalled(){

        String name = "Oil plus";
        String description = "Nice oil";

        OilEntity expectedResult = new OilEntity(null,name, OilTypeEnum.TYPE_5W_30, description, new byte[]{10,10});
        OilDTO toTransform = new OilDTO(name, OilTypeEnum.TYPE_5W_30, description, new byte[]{10,10});

        Assert.assertEquals("Should be the same", expectedResult, toTransform.toOilEntity());
    }



    @Test
    public void shouldValidationAnnotationsOnEachAttribute_when_userDTOObjectIsBuilt() throws NoSuchFieldException {

        Boolean isNotBlankPresentInNameField = AnnotationCheckHelper.doesFieldContainsAnnotation(OilDTO.class, "name", NotBlank.class);
        Boolean isNotNullPresentInTypeField = AnnotationCheckHelper.doesFieldContainsAnnotation(OilDTO.class, "type", NotNull.class);
        Boolean isNotBlankPresentInDescriptionField = AnnotationCheckHelper.doesFieldContainsAnnotation(OilDTO.class, "description", NotBlank.class);
        Boolean isAnyAnnotationPresentInImageField = AnnotationCheckHelper.isThereAnyPresentAnnotation(OilDTO.class, "image");

        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInNameField);
        assertTrue("Should have @NotNull to validate itself",isNotNullPresentInTypeField);
        assertTrue("Should have @NotBlank to validate itself",isNotBlankPresentInDescriptionField);
        Assert.assertFalse("Should not have any annotation to validate itself",isAnyAnnotationPresentInImageField);

    }

}
