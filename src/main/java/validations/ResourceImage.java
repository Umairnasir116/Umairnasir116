package validations;

import config.ConfigProperties;
import config.EnvGlobals;
import config.ReusableFunctions;
import org.junit.Assert;

public class ResourceImage {


    public static void verifyImageUpload()
    {
        Assert.assertTrue(Boolean.parseBoolean(ReusableFunctions.getResponsePath("requestResponse.result")));
        Assert.assertNotNull(ReusableFunctions.getResponsePath("requestResponse.msg"));
    }

}
