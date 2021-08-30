package testcases;
import config.ConfigProperties;
import config.EndpointURLs;
import config.EnvGlobals;
import config.ReusableFunctions;
import general.BaseTest;
import org.testng.annotations.Test;

public class User extends BaseTest {

    @Test (description = "Verify user login")
    public static void userLogin() {
        String requestPayload = payloads.User.userLogin(ConfigProperties.email,ConfigProperties.password);
        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), requestPayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl+EnvGlobals.version + EndpointURLs.userLogin);
        ReusableFunctions.thenFunction(200);
        EnvGlobals.interestLength =ReusableFunctions.getResponseLengthByKey("userProfile.interest.size()");
        EnvGlobals.authorizationToken= ReusableFunctions.getPathResponse("userProfile.authentication.token");
        validations.Users.VerifyLoginUser();

    }


    @Test (description = "Verify user is valid")
    public static void validUser() {
        String requestPayload = payloads.User.validUser(EnvGlobals.authorizationToken);
        ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), requestPayload);
        ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl + EnvGlobals.version + EndpointURLs.validUser);
        ReusableFunctions.thenFunction(200);
        validations.Users.verifyValidUser();

    }


}
