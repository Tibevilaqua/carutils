package com.caroffice.endpoint.model;

import com.caroffice.entity.ModelEntity;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 03/01/17.
 */
public class ModelDTOTest {


    @Test
    public void shouldReturnCorrespondentDTO_when_modelEntityIsSentAsArgument(){

        String name = "208";
        String brandName = "Peugeot";

        ModelDTO modelDTO = new ModelEntity(name,brandName).toDTO();

        Assert.assertEquals("Should be the same", name, modelDTO.getName());
        Assert.assertEquals("Should be the same", brandName, modelDTO.getBrandName());
    }

}
