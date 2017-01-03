package com.caroffice.business;

import com.caroffice.endpoint.model.ModelDTO;
import com.caroffice.entity.ModelEntity;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.infrastructure.exception.ExceptionEnum;
import com.caroffice.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by root on 03/01/17.
 */
@Service
public class ModelBusiness {

    private ModelRepository modelRepository;

    public ModelBusiness(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<ModelDTO> getModelsByBrand(String name) {

        List<ModelEntity> result = modelRepository.findByBrandName(name);

        if(result == null || result.isEmpty()){
            throw new CustomException(ExceptionEnum.MODEL_NOT_FOUND);
        }

        return result.stream().sequential().map(ModelEntity::toDTO).collect(Collectors.toList());
    }
}
