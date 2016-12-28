package com.caroffice.infrastructure.exception;

import com.caroffice.infrastructure.validation.ValidationErrorDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Created by root on 05/12/16.
 */
public class GlobalControllerExceptionHandlerTest {



    @Test
    public void shouldReturnOilNotFound_when_thereIsNoOil(){

        for(ExceptionEnum ee : ExceptionEnum.values()){

        CustomException ce = new CustomException(ee);
        ResponseEntity<ValidationErrorDTO> exceptionDTOResponseEntity = new GlobalControllerExceptionHandler().handleConflict(ce);

        Assert.assertSame(exceptionDTOResponseEntity.getStatusCode(), ce.getHttpStatus());
        Assert.assertSame(exceptionDTOResponseEntity.getBody().getErrors().get(0).getMessage(), ee.getDescription());
        Assert.assertSame(exceptionDTOResponseEntity.getBody().getErrors().get(0).getName(), ee.getField());
        }
    }

}
