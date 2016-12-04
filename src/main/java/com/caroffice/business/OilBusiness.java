package com.caroffice.business;

import com.caroffice.entity.OilEntity;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.exception.ExceptionEnum;
import com.caroffice.repository.OilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public OilEntity getOilBy(Integer id){
        return Optional.ofNullable(oilRepository.findById(id))
                .orElseThrow(() -> new CustomException(ExceptionEnum.OIL_NOT_FOUND));
    }


}

