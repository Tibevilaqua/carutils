package com.caroffice.entity;

import com.caroffice.endpoint.oil.OilDTO;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 27/12/16.
 */
public class OilEntityTest {


    @Test
    public void shouldReturnOilDTO_when_toDTOMethodIsCalled(){

        String name = "Oil plus";
        String description = "Nice oil";

        OilDTO expectedResult = new OilDTO(name, OilTypeEnum.TYPE_5W_30, description, new byte[]{10,10});
        OilEntity toTransform = new OilEntity(null,name, OilTypeEnum.TYPE_5W_30, description, new byte[]{10,10});

        Assert.assertEquals("Should be the same", expectedResult, toTransform.toDTO());
    }


}
