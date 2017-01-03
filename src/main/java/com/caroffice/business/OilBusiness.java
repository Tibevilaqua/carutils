package com.caroffice.business;

import com.caroffice.endpoint.oil.OilDTO;
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

    public OilDTO getOilBy(String name){
        return new OilDTO(Optional.ofNullable(oilRepository.findByName(name))
                .orElseThrow(() -> new CustomException(ExceptionEnum.OIL_NOT_FOUND)));
    }

    /**
     * Save the new OilEntity in the database </br>
     * Throws CustomException(ExceptionEnum.OIL_CONFLICT) in case the oil
     * name is already inserted in the database
     * @param oilDTO
     */
    public void save(OilDTO oilDTO){
        OilEntity oilEntity = oilDTO.toOilEntity();

        Optional.ofNullable(oilRepository.findByName(oilEntity.getName())).ifPresent(oil -> {throw new CustomException(ExceptionEnum.OIL_CONFLICT);});

        oilRepository.save(oilEntity);
    }


    public OilDTO update(OilDTO oilDTO) {

        OilEntity oilEntity = oilDTO.toOilEntity();

        OilEntity oil = Optional.ofNullable(oilRepository.findByName(oilEntity.getName())).orElseThrow(() -> new CustomException(ExceptionEnum.OIL_NOT_FOUND));

        //Update if value is not null
        Optional.ofNullable(oilEntity.getImage()).ifPresent(image -> oil.setImage(image));
        Optional.ofNullable(oilEntity.getDescription()).ifPresent(description -> oil.setDescription(description));
        Optional.ofNullable(oilEntity.getName()).ifPresent(name -> oil.setName(name));
        Optional.ofNullable(oilEntity.getType()).ifPresent(type -> oil.setType(type));

        return oilRepository.save(oil).toDTO();

    }




}

