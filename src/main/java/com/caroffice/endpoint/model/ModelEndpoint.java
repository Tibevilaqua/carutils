package com.caroffice.endpoint.model;

import com.caroffice.business.ModelBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.caroffice.endpoint.Resources.MODEL;

/**
 * Created by root on 03/01/17.
 */
@RestController
public class ModelEndpoint {

    @Autowired
    private ModelBusiness modelBusiness;

    public ModelEndpoint(ModelBusiness modelBusiness) {
        this.modelBusiness = modelBusiness;
    }

    @RequestMapping(value = MODEL,method = RequestMethod.GET)
    public List<ModelDTO> getBy(@RequestParam String brandName) {
        return modelBusiness.getModelsByBrand(brandName);
    }


}
