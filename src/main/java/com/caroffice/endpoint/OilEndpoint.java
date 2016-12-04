package com.caroffice.endpoint;

import com.caroffice.Entity.Oil;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.exception.ExceptionEnum;
import com.caroffice.infrastructure.oil.OilType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.caroffice.endpoint.Resources.GET_OIL;


/**
 * Created by root on 05/12/16.
 */
@RestController

public class OilEndpoint {


    @RequestMapping(value = GET_OIL,method = RequestMethod.GET)
    public Oil getBy(@PathVariable Integer id) {

        if(id != 1){
            throw new CustomException(ExceptionEnum.OIL_NOT_FOUND);
        }

        return new Oil(id, "Lubrax", OilType.TYPE_5W_30,"Good stuff");
    }

}
