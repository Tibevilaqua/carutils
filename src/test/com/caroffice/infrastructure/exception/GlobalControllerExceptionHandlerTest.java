package com.caroffice.infrastructure.exception;

import com.caroffice.infrastructure.validation.ValidationErrorDTO;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;

/**
 * Created by root on 05/12/16.
 */
public class GlobalControllerExceptionHandlerTest {



    @Test
    public void shouldReturnExpected_when_itIsThrown(){

        for(ExceptionEnum ee : ExceptionEnum.values()){

        CustomException ce = new CustomException(ee);
        ResponseEntity<ValidationErrorDTO> exceptionDTOResponseEntity = new GlobalControllerExceptionHandler().handleConflict(ce);

        Assert.assertSame(exceptionDTOResponseEntity.getStatusCode(), ce.getHttpStatus());
        Assert.assertSame(exceptionDTOResponseEntity.getBody().getErrors().get(0).getMessage(), ee.getDescription());
        Assert.assertSame(exceptionDTOResponseEntity.getBody().getErrors().get(0).getName(), ee.getField());
        }
    }

    @Test
    public void shouldReturnExceptionFieldAndMessage_when_validationCatchesAnInaccuracy(){


        BindingResult  br = Mockito.spy(BindingResult.class);
        String name = "name";
        String defaultMessage = "name error message";
        Mockito.when(br.getAllErrors()).thenReturn(Arrays.asList(new FieldError("doesNotMatter", name, defaultMessage)));

        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(null, br);
        ValidationErrorDTO validationErrorDTO = new GlobalControllerExceptionHandler().handleConflict(methodArgumentNotValidException);

        Assert.assertSame(validationErrorDTO.getErrors().get(0).getName(), name);
        Assert.assertSame(validationErrorDTO.getErrors().get(0).getMessage(), defaultMessage);

    }

}
