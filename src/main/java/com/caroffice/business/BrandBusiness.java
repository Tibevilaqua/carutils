package com.caroffice.business;

import com.caroffice.endpoint.brand.BrandDTO;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.exception.ExceptionEnum;
import com.caroffice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by root on 03/01/17.
 */
@Service
public class BrandBusiness {

    @Autowired
    private BrandRepository brandRepository;

    public BrandBusiness(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public BrandDTO getBrandBy(String name){
        return Optional.ofNullable(brandRepository.findByName(name))
                .orElseThrow(() -> new CustomException(ExceptionEnum.BRAND_NOT_FOUND)).toDTO();
    }



}
