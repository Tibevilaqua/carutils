package com.caroffice.repository;

import com.caroffice.entity.OilEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by root on 05/12/16.
 */
@Repository
public interface OilRepository extends CrudRepository<OilEntity, BigInteger> {

    OilEntity findByName(String name);

}
