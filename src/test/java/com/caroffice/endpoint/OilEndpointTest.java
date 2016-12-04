package com.caroffice.endpoint;

import com.caroffice.entity.OilEntity;
import com.caroffice.business.OilBusiness;
import com.caroffice.infrastructure.oil.OilTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by root on 04/12/16.
 */
public class OilEndpointTest {



    @Test
    public void firstTest(){

        int oilId = 1;
        OilBusiness oilBusinessMocked = Mockito.mock(OilBusiness.class);
        Mockito.when(oilBusinessMocked.getOilBy(oilId)).thenReturn(new OilEntity(oilId,"a", OilTypeEnum.TYPE_5W_30,"Description"));
        OilEntity result = new OilEndpoint(oilBusinessMocked).getBy(oilId);
        Assert.assertEquals(oilId,result.getId().intValue());
    }


}
