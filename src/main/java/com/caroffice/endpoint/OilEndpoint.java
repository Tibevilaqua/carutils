package com.caroffice.endpoint;

import com.caroffice.entity.OilEntity;
import com.caroffice.business.OilBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.caroffice.endpoint.Resources.GET_OIL;


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

    @RequestMapping(value = GET_OIL,method = RequestMethod.GET)
    public OilEntity getBy(@PathVariable Integer id) {

        return oilBusiness.getOilBy(id);

    }

}
