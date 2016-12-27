package com.caroffice.endpoint.oil;

import com.caroffice.business.OilBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(value = OIL,method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody OilDTO oilDTO) {
        oilBusiness.save(oilDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}