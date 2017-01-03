package com.caroffice.endpoint.brand;

import com.caroffice.entity.BrandEntity;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 03/01/17.
 */
public class BrandDTOTest {

    @Test
    public void shouldReturnCorrespondentDTO_when_brandEntityIsSentAsArgument(){

        String name = "Peugeot";
        byte[] image =  new byte[]{10,20};

        BrandDTO brandDTO = new BrandDTO(new BrandEntity(name,image));

        Assert.assertEquals("Should be the same", name, brandDTO.getName());
        Assert.assertEquals("Should be the same", image, brandDTO.getImage());
    }


}
