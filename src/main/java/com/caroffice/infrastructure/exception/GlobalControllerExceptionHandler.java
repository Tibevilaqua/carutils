package com.caroffice.infrastructure.exception;

import com.caroffice.infrastructure.oil.OilTypeEnum;
import com.caroffice.infrastructure.validation.ValidationErrorDTO;
import com.caroffice.infrastructure.validation.ValidationErrorBuilder;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * Created by root on 05/12/16.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<ValidationErrorDTO> handleConflict(CustomException customException) {

        HttpStatus responseStatus = customException.getHttpStatus();

        return new ResponseEntity<>(ValidationErrorBuilder.fromBindingErrors(customException.getField(), customException.getDescription()), responseStatus);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationErrorDTO handleConflict(MethodArgumentNotValidException e) {
        return ValidationErrorBuilder.fromBindingErrors(e.getBindingResult());
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationErrorDTO handleConflict(InvalidFormatException e) {
        String targetedTypeName = e.getTargetType().getTypeName();
        if(OilTypeEnum.class.getName().equals(targetedTypeName)){
            targetedTypeName = OilTypeEnum.getTypeAttributeName();
        }

        return ValidationErrorBuilder.fromBindingErrors(targetedTypeName);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationErrorDTO bodyNotSent(HttpMessageNotReadableException e) {

        if(e.getCause() instanceof InvalidFormatException){
           return handleConflict((InvalidFormatException) e.getCause());
        }

        return ValidationErrorBuilder.bodyNotSent();
    }    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationErrorDTO bodyNotSent(MissingServletRequestPartException e) {


        return ValidationErrorBuilder.fromBindingErrors(e.getRequestPartName(),ExceptionEnum.INVALID_OIL_IMAGE.getDescription());
    }

}
