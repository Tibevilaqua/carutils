package com.caroffice.repository;

import com.caroffice.entity.ModelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by root on 03/01/17.
 */
@Repository
public interface ModelRepository  extends CrudRepository<ModelEntity, BigInteger> {

    List<ModelEntity> findByBrandName(String name);

}