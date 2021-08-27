package validations;

import config.ConfigProperties;
import config.EnvGlobals;
import config.ReusableFunctions;
import org.junit.Assert;

public class Users {


    public static void VerifyLoginUser() {

        Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.userID"));
        Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.neighbourHoodId"));
        Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.subCommunityId"));
        Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.authentication.token"));
        Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.firstName"));
        Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.lastName"));
        Assert.assertEquals(ReusableFunctions.getResponsePath("userProfile.email"), ConfigProperties.email );
        Assert.assertEquals(ReusableFunctions.getResponsePath("userProfile.gender"),"Male");
        Assert.assertEquals(ReusableFunctions.getResponsePath("userProfile.neighbourHood"),"Karachi");
        Assert.assertEquals(ReusableFunctions.getResponsePath("userProfile.subCommunity"),"Johar Town");
        Assert.assertEquals(ReusableFunctions.getResponsePath("userProfile.address"),"Johar Town Karachi");
        Assert.assertEquals(ReusableFunctions.getResponsePath("userProfile.role"), "User");
        for (int i=0 ; i< EnvGlobals.interestLength ; i++)
        {
            Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.interest["+i+"].interestId"));
            Assert.assertNotNull(ReusableFunctions.getResponsePath("userProfile.interest["+i+"].name"));

        }

    }

    public static void verifyValidUser()
    {
        Assert.assertTrue(Boolean.parseBoolean(ReusableFunctions.getResponsePath("isValid")));
        Assert.assertTrue(Boolean.parseBoolean(ReusableFunctions.getResponsePath(" requestResponse.result")));

    }

}
