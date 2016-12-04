package com.caroffice.business;

import com.caroffice.entity.OilEntity;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import com.caroffice.repository.OilRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by root on 05/12/16.
 */
public class OilBusinessTest {

    OilRepository oilRepositoryMocked;

    @Before
    public void setUp(){
        oilRepositoryMocked = Mockito.mock(OilRepository.class);
    }


    @Test
    public void shouldReturnOil_when_OilIsFound(){
        final int defaultId = 10;
        OilEntity oiToBeSent = new OilEntity(defaultId,"James", OilTypeEnum.TYPE_5W_30,"Crazy mate!");
        Mockito.when(oilRepositoryMocked.findById(defaultId)).thenReturn(oiToBeSent);
        OilEntity returnedOil = new OilBusiness(oilRepositoryMocked).getOilBy(defaultId);

        Assert.assertSame(oiToBeSent, returnedOil);
    }

    @Test(expected = CustomException.class)
    public void shouldReturnException_when_NoOilIsFound(){
        Mockito.when(oilRepositoryMocked.findById(10)).thenReturn(null);
        new OilBusiness(oilRepositoryMocked).getOilBy(10);
    }

}
