package com.caroffice.endpoint;

/**
 * Created by root on 05/12/16.
 */
public interface Resources {


//  Resources
    String OIL = "/oil";
    String USER = "/user";
    String BRAND = "/brand/{id}";
    String MODEL = "/model";


//  OilEntity Requests
    String GET_OIL = OIL + "/{name}";

}
