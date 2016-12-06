package com.caroffice.repository;

import com.caroffice.entity.OilEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

/**
 * Created by root on 05/12/16.
 */
@org.springframework.stereotype.Repository
public interface OilRepository extends CrudRepository<OilEntity, BigInteger> {

    OilEntity findByName(String name);

}
