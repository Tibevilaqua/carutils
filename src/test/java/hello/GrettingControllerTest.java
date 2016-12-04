package hello;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 04/12/16.
 */
public class GrettingControllerTest {


    @Test
    public void firstTest(){
        Greeting result = new GreetingController().greeting("World");
        Assert.assertEquals("Hello, World!",result.getContent());

    }


}
