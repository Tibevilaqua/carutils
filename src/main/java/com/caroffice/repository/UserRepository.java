package com.caroffice.repository;

import com.caroffice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by root on 27/12/16.
 */
@Repository
public interface UserRepository  extends CrudRepository<UserEntity, BigInteger> {
}
