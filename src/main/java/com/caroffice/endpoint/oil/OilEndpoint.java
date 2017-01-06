package com.caroffice.endpoint.oil;

import com.caroffice.business.OilBusiness;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.exception.ExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.io.IOException;

import static com.caroffice.endpoint.Resources.OIL;


/**
 * Created by root on 05/12/16.
 */
@RestController
public class OilEndpoint {

    @Autowired
    private OilBusiness oilBusiness;

    public OilEndpoint(OilBusiness oilBusiness) {
        this.oilBusiness = oilBusiness;
    }

    @RequestMapping(value = OIL,method = RequestMethod.GET)
    public OilDTO getBy(@RequestParam String name) {
        return oilBusiness.getOilBy(name);
    }


    @RequestMapping(value = OIL,method = RequestMethod.POST,  consumes = {"multipart/form-data"})
    public ResponseEntity<Void> save(
            @RequestPart("image") MultipartFile image,
            @Valid @RequestPart OilDTO oilDTO) {

        try {
            oilDTO.setImage(image.getBytes());
        } catch (IOException e) {
            throw new CustomException(ExceptionEnum.INVALID_OIL_IMAGE);
        }

        oilBusiness.save(oilDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
