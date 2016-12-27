package com.caroffice.business;

import com.caroffice.endpoint.user.UserDTO;
import com.caroffice.entity.UserEntity;
import com.caroffice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 27/12/16.
 */
@Service
public class UserBusiness {

    @Autowired
    private UserRepository userRepository;


    public UserBusiness(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserDTO userDTO) {
        UserEntity userEntity = userDTO.toUserEntity();
        userRepository.save(userEntity);
    }
}
