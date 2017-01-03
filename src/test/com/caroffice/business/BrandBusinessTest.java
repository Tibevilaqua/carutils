package com.caroffice.business;

import com.caroffice.endpoint.brand.BrandDTO;
import com.caroffice.entity.BrandEntity;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.repository.BrandRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by root on 03/01/17.
 */
public class BrandBusinessTest {


    BrandRepository brandRepositoryMocked;
    private final static ObjectId defaultId = new ObjectId();
    private final static String defaultName = "Peugeot";
    private final static byte[] defaultImage = new byte[]{10,20};


    @Before
    public void setUp(){
        brandRepositoryMocked = Mockito.mock(BrandRepository.class);
    }

    @Test
    public void shouldReturnOil_when_OilIsFound(){

        BrandEntity brandEntityReturned = new BrandEntity(defaultName, defaultImage);
        BrandDTO expectedBrand = new BrandDTO(defaultName, defaultImage);
        Mockito.when(brandRepositoryMocked.findByName(defaultName)).thenReturn(brandEntityReturned);
        BrandDTO returnedBrand = new BrandBusiness(brandRepositoryMocked).getBrandBy(defaultName);

        Assert.assertEquals(expectedBrand, returnedBrand);
    }


    @Test(expected = CustomException.class)
    public void shouldReturnException_when_NoBrandIsFound(){
        Mockito.when(brandRepositoryMocked.findByName(defaultName)).thenReturn(null);
        new BrandBusiness(brandRepositoryMocked).getBrandBy(defaultName);
    }

}
