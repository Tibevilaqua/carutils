package com.caroffice;

import com.caroffice.Entity.Oil;
import com.caroffice.endpoint.OilEndpoint;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 04/12/16.
 */
public class OilEndpointTest {

    @Test
    public void firstTest(){
        int oilId = 1;
        Oil result = new OilEndpoint().getBy(oilId);
        Assert.assertEquals(oilId,result.getId().intValue());
    }


}
