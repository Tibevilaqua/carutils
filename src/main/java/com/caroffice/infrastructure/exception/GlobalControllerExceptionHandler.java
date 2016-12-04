package com.caroffice.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by root on 05/12/16.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<ExceptionDTO> handleConflict(CustomException customException) {

        HttpStatus responseStatus = customException.getHttpStatus();
        return new ResponseEntity<>(new ExceptionDTO(customException.getDescription()), responseStatus);
    }

}
