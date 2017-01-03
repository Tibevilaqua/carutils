package com.caroffice.endpoint.brand;

import com.caroffice.business.BrandBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.caroffice.endpoint.Resources.BRAND;


/**
 * Created by root on 05/12/16.
 */
@RestController
public class BrandEndpoint {

    @Autowired
    private BrandBusiness brandBusiness;

    public BrandEndpoint(BrandBusiness brandBusiness) {
        this.brandBusiness= brandBusiness;
    }

    @RequestMapping(value = BRAND,method = RequestMethod.GET)
    public BrandDTO getBy(@PathVariable String id) {
        return brandBusiness.getBrandBy(id);
    }

}
