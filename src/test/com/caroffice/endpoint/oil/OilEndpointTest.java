package com.caroffice.endpoint.oil;

import com.caroffice.endpoint.oil.OilDTO;
import com.caroffice.endpoint.oil.OilEndpoint;
import com.caroffice.business.OilBusiness;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by root on 04/12/16.
 */
public class OilEndpointTest {

    private final static String defaultName = "James";

    @Test
    public void shouldSearch_when_OilExist(){

        OilBusiness oilBusinessMocked = Mockito.mock(OilBusiness.class);
        Mockito.when(oilBusinessMocked.getOilBy(defaultName)).thenReturn(new OilDTO(defaultName, OilTypeEnum.TYPE_5W_30,"Description",null));
        OilDTO result = new OilEndpoint(oilBusinessMocked).getBy(defaultName);
        Assert.assertEquals(defaultName,result.getName());
    }

    @Test
    public void shouldSaveAndReturnCreated_when_OilDTOIsAlright(){
        OilDTO oilEntity = new OilDTO();
        OilBusiness oilBusinessMocked = Mockito.mock(OilBusiness.class);
        Mockito.doNothing().when(oilBusinessMocked).save(oilEntity);
        OilDTO oilDTO = new OilDTO();
        MultipartFile image = Mockito.mock(MultipartFile.class);
        ResponseEntity<Void> createdOil = new OilEndpoint(oilBusinessMocked).save(image, oilDTO);
        Assert.assertEquals(createdOil.getStatusCode(), HttpStatus.CREATED);
    }


    @Test(expected = CustomException.class)
    public void shouldThrowCustomException_when_ImageIsInvalid() throws IOException{
        OilDTO oilEntity = new OilDTO();
        OilBusiness oilBusinessMocked = Mockito.mock(OilBusiness.class);
        Mockito.doNothing().when(oilBusinessMocked).save(oilEntity);
        OilDTO oilDTO = new OilDTO();
        MultipartFile image = Mockito.mock(MultipartFile.class);
        Mockito.when(image.getBytes()).thenThrow(IOException.class);
        ResponseEntity<Void> createdOil = new OilEndpoint(oilBusinessMocked).save(image, oilDTO);
    }


}
