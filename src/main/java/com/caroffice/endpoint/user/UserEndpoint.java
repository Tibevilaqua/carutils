package com.caroffice.endpoint.user;

import com.caroffice.business.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.caroffice.endpoint.Resources.USER;

/**
 * Created by root on 27/12/16.
 */
@RestController
public class UserEndpoint {

    @Autowired
    private UserBusiness userBusiness;

    public UserEndpoint(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @RequestMapping(value = USER,method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody UserDTO userDTO) {
        userBusiness.save(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
