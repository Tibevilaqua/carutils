package com.caroffice.business;

import com.caroffice.endpoint.Oil.OilDTO;
import com.caroffice.entity.OilEntity;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.exception.ExceptionEnum;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import com.caroffice.repository.OilRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.mockito.Matchers.anyString;

/**
 * Created by root on 05/12/16.
 */
public class OilBusinessTest {

    OilRepository oilRepositoryMocked;
    private final static ObjectId defaultId = new ObjectId();
    private final static String defaultName = "James";


    @Before
    public void setUp(){
        oilRepositoryMocked = Mockito.mock(OilRepository.class);
    }


    @Test
    public void shouldReturnOil_when_OilIsFound(){

        OilEntity oilEntityReturned = new OilEntity(defaultId, "James", OilTypeEnum.TYPE_5W_30,"Crazy mate!");
        OilDTO oiToBeSent = new OilDTO("James", OilTypeEnum.TYPE_5W_30,"Crazy mate!");
        Mockito.when(oilRepositoryMocked.findByName(defaultName)).thenReturn(oilEntityReturned);
        OilDTO returnedOil = new OilBusiness(oilRepositoryMocked).getOilBy(defaultName);

        Assert.assertEquals(oiToBeSent, returnedOil);
    }

    @Test(expected = CustomException.class)
    public void shouldReturnException_when_NoOilIsFound(){
        Mockito.when(oilRepositoryMocked.findByName(defaultName)).thenReturn(null);
        new OilBusiness(oilRepositoryMocked).getOilBy(defaultName);
    }

    @Test
    public void shouldSaveObject_when_everythingIsAlright(){
        OilEntity oilEntity = new OilEntity(null,"a",OilTypeEnum.TYPE_5W_30,"d");
        Mockito.when(oilRepositoryMocked.save(oilEntity)).thenReturn(oilEntity);
        Mockito.when(oilRepositoryMocked.findByName(oilEntity.getName())).thenReturn(null);
        new OilBusiness(oilRepositoryMocked).save(oilEntity);
    }


    @Test(expected = CustomException.class)
    public void shouldThrowConflictException_when_tryingToSaveWithTheSameOilName(){
        OilEntity oilEntity = new OilEntity(null,"a",OilTypeEnum.TYPE_5W_30,"d");
        Mockito.when(oilRepositoryMocked.findByName(oilEntity.getName())).thenReturn(new OilEntity());

        try {
            new OilBusiness(oilRepositoryMocked).save(oilEntity);
        }catch (CustomException c){
            Assert.assertEquals(c.getDescription(), ExceptionEnum.OIL_CONFLICT.getDescription());
            Assert.assertEquals(c.getHttpStatus(), ExceptionEnum.OIL_CONFLICT.getHttpStatus());
            throw new CustomException(ExceptionEnum.OIL_CONFLICT);
        }
        Assert.fail();
    }




}
