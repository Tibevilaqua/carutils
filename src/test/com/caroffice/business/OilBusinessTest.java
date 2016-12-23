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

import static org.mockito.Matchers.any;
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

        OilEntity oilEntityReturned = new OilEntity(defaultId, "James", OilTypeEnum.TYPE_5W_30,"Crazy mate!",null);
        OilDTO oiToBeSent = new OilDTO("James", OilTypeEnum.TYPE_5W_30,"Crazy mate!",null);
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
        OilDTO oilDTO = new OilDTO("a",OilTypeEnum.TYPE_5W_30,"d",null);
        OilEntity oilEntity = oilDTO.toOilEntity();
        Mockito.when(oilRepositoryMocked.save(oilEntity)).thenReturn(oilEntity);
        Mockito.when(oilRepositoryMocked.findByName(oilDTO.getName())).thenReturn(null);
        new OilBusiness(oilRepositoryMocked).save(oilDTO);
    }


    @Test(expected = CustomException.class)
    public void shouldThrowConflictException_when_tryingToSaveWithTheSameOilName(){
        OilDTO oilEntity = new OilDTO("a",OilTypeEnum.TYPE_5W_30,"d",null);
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

    @Test(expected = CustomException.class)
    public void shouldReturnException_when_NoOilIsFoundToUpdating(){
        OilDTO oilDTO = new OilDTO(defaultName, null, null, null);
        Mockito.when(oilRepositoryMocked.findByName(defaultName)).thenReturn(null);
        new OilBusiness(oilRepositoryMocked).update(oilDTO);
    }

    @Test
    public void souldUpdateOil_when_valuesAreValid(){
        OilDTO originalOil = new OilDTO(defaultName, OilTypeEnum.TYPE_5W_30, "A", null);
        OilDTO newOil = new OilDTO(defaultName, OilTypeEnum.TYPE_5W_30, "new Description", new byte[]{});
        Mockito.when(oilRepositoryMocked.findByName(defaultName)).thenReturn(originalOil.toOilEntity());
        Mockito.when(oilRepositoryMocked.save(newOil.toOilEntity())).thenReturn(newOil.toOilEntity());
        OilDTO updatedOil = new OilBusiness(oilRepositoryMocked).update(newOil);

        Assert.assertEquals(newOil, updatedOil);

    }




}
