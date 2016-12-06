package com.caroffice.endpoint;

import com.caroffice.endpoint.Oil.OilDTO;
import com.caroffice.endpoint.Oil.OilEndpoint;
import com.caroffice.entity.OilEntity;
import com.caroffice.business.OilBusiness;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by root on 04/12/16.
 */
public class OilEndpointTest {

    private final static String defaultName = "James";

    @Test
    public void shouldSearch_when_OilExist(){

        OilBusiness oilBusinessMocked = Mockito.mock(OilBusiness.class);
        Mockito.when(oilBusinessMocked.getOilBy(defaultName)).thenReturn(new OilDTO(defaultName, OilTypeEnum.TYPE_5W_30,"Description"));
        OilDTO result = new OilEndpoint(oilBusinessMocked).getBy(defaultName);
        Assert.assertEquals(defaultName,result.getName());
    }

    @Test
    public void shouldSaveAndReturnCreated_when_OilDTOIsAlright(){
        OilEntity oilEntity = new OilEntity();
        OilBusiness oilBusinessMocked = Mockito.mock(OilBusiness.class);
        Mockito.doNothing().when(oilBusinessMocked).save(oilEntity);
        OilDTO oilDTO = new OilDTO();
        ResponseEntity<Void> createdOil = new OilEndpoint(oilBusinessMocked).save(oilDTO);
        Assert.assertEquals(createdOil.getStatusCode(), HttpStatus.CREATED);
    }


}
