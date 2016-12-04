package com.caroffice.repository;

import com.caroffice.entity.OilEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by root on 05/12/16.
 */
@org.springframework.stereotype.Repository
public interface OilRepository extends CrudRepository<OilEntity, Integer> {

    OilEntity findById(Integer id);

}
