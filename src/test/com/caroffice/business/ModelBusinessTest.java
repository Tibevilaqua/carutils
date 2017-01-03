package com.caroffice.business;

import com.caroffice.endpoint.model.ModelDTO;
import com.caroffice.entity.ModelEntity;
import com.caroffice.infrastructure.exception.CustomException;
import com.caroffice.repository.ModelRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by root on 03/01/17.
 */
public class ModelBusinessTest {


    ModelRepository modelRepositoryMocked;
    private final static ObjectId defaultId = new ObjectId();
    private final static String defaultBrandName = "Peugeot";


    @Before
    public void setUp(){
        modelRepositoryMocked = Mockito.mock(ModelRepository.class);
    }


    @Test
    public void shouldReturnModelList_when_ModelsAreFound(){


        List<ModelEntity> listReturned = Arrays.asList(new ModelEntity("207", defaultBrandName),new ModelEntity("208", defaultBrandName));
        List<ModelDTO> expectedResult = listReturned.stream().map(ModelEntity::toDTO).collect(Collectors.toList());


        Mockito.when(modelRepositoryMocked.findByBrandName(defaultBrandName)).thenReturn(listReturned);
        List<ModelDTO> returnedModelList = new ModelBusiness(modelRepositoryMocked).getModelsByBrand(defaultBrandName);

        Assert.assertEquals(expectedResult, returnedModelList);
    }



    @Test(expected = CustomException.class)
    public void shouldReturnException_when_returnedModelIsNull(){
        Mockito.when(modelRepositoryMocked.findByBrandName(defaultBrandName)).thenReturn(null);
        new ModelBusiness(modelRepositoryMocked).getModelsByBrand(defaultBrandName);
    }

    @Test(expected = CustomException.class)
    public void shouldReturnException_when_returnedModelIsEmpty(){
        Mockito.when(modelRepositoryMocked.findByBrandName(defaultBrandName)).thenReturn(Collections.EMPTY_LIST);
        new ModelBusiness(modelRepositoryMocked).getModelsByBrand(defaultBrandName);
    }




}
