package com.caroffice.endpoint.user;

import com.caroffice.business.UserBusiness;
import com.caroffice.endpoint.user.UserDTO;
import com.caroffice.endpoint.user.UserEndpoint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by root on 27/12/16.
 */
public class UserEndpointTest {

    private UserBusiness userBusiness;

    @Before
    public void setUp(){
        userBusiness = Mockito.mock(UserBusiness.class);
    }

    @Test
    public void shouldHaveValidateAnnotation_when_saveEndpointIsCalled(){
            Method saveUserMethod = null;

            try {
                saveUserMethod = UserEndpoint.class.getMethod("save", UserDTO.class);
            } catch (NoSuchMethodException e) {
                //If there's no save method, then, fail.
                Assert.fail();
            }


            Parameter[] parameters = saveUserMethod.getParameters();
            boolean isValidPresent = false;
            boolean isRequestBodyPresent = false;
            for(Parameter p : parameters){
                isValidPresent = p.getAnnotation(Valid.class) != null ? true : false;
                isRequestBodyPresent = p.getAnnotation(RequestBody.class) != null ? true : false;
            }
            Assert.assertTrue("Annotation @Valid must be present", isValidPresent);
            Assert.assertTrue("Annotation @RequestBody must be present", isRequestBodyPresent);
        }




    @Test
    public void shouldReturnCreated_when_userIsSavedSuccessfully(){

        UserDTO doesNotMatterUserDTOInstance = new UserDTO();
        Mockito.doNothing().when(userBusiness).save(doesNotMatterUserDTOInstance);
        ResponseEntity<Void> response = new UserEndpoint(this.userBusiness).save(doesNotMatterUserDTOInstance);

        Assert.assertTrue("Returned status should be Created {201} ", HttpStatus.CREATED == response.getStatusCode());
    }



}
