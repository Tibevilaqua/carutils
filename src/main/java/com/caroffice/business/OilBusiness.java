package com.caroffice.business;

import com.caroffice.endpoint.Oil.OilDTO;
import com.caroffice.entity.OilEntity;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.exception.ExceptionEnum;
import com.caroffice.repository.OilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

/**
 * Created by root on 05/12/16.
 */
@Service
public class OilBusiness {

    @Autowired
    private OilRepository oilRepository;


    public OilBusiness(OilRepository oilRepository) {
        this.oilRepository = oilRepository;
    }

    public OilDTO getOilBy(String name){
        return new OilDTO(Optional.ofNullable(oilRepository.findByName(name))
                .orElseThrow(() -> new CustomException(ExceptionEnum.OIL_NOT_FOUND)));
    }


    public void save(OilEntity oilEntity){
        oilRepository.save(oilEntity);
    }


}

