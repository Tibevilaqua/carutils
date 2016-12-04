package com.caroffice.infrastructure.exception;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Created by root on 05/12/16.
 */
public class GlobalControllerExceptionHandlerTest {



    @Test
    public void shouldReturnOilNotFound_when_thereIsNoOil(){
        ExceptionEnum ee = ExceptionEnum.OIL_NOT_FOUND;

        CustomException ce = new CustomException(ee);
        ResponseEntity<ExceptionDTO> exceptionDTOResponseEntity = new GlobalControllerExceptionHandler().handleConflict(ce);

        Assert.assertSame(exceptionDTOResponseEntity.getStatusCode(), ce.getHttpStatus());
        Assert.assertSame(exceptionDTOResponseEntity.getBody().getMessage(), ee.getDescription());
    }

}
