package com.caroffice.repository;

import com.caroffice.entity.BrandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;

/**
 * Created by root on 03/01/17.
 */
@Repository
public interface BrandRepository  extends CrudRepository<BrandEntity, BigInteger> {

    BrandEntity findByName(String name);

}
