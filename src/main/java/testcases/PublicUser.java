package testcases;

import config.ConfigProperties;
import config.EndpointURLs;
import config.EnvGlobals;
import config.ReusableFunctions;
import general.BaseTest;
import org.testng.annotations.Test;
public class PublicUser extends BaseTest {



        @Test (description = "")
        public void createUser() {
            String Requestpayload = payloads.PublicUser.createUser();

            ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers("Authorization", null), Requestpayload);
            ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl + EndpointURLs.createUser2);
            ReusableFunctions.thenFunction(201);
            EnvGlobals.userId = ReusableFunctions.getResponsePath("id");

            validations.PublicUser.VerifyUser2(Requestpayload);


        }

        @Test
        public void updateUser () {
            String Requestpayload = payloads.PublicUser.updateUser();

            ReusableFunctions.givenHeaderPayload(ReusableFunctions.headers(), Requestpayload);
            ReusableFunctions.whenFunction("put", ConfigProperties.baseUrl + EndpointURLs.createUser2);
            ReusableFunctions.thenFunction(200);

            validations.PublicUser.verifyUpdatedUser(Requestpayload);



        }

        @Test
        public void getUsersList() {
            ReusableFunctions.givenHeaders(ReusableFunctions.headers());
            ReusableFunctions.whenFunction("get", ConfigProperties.baseUrl + EndpointURLs.User2List);
            ReusableFunctions.thenFunction(200);
            EnvGlobals.pagesize = ReusableFunctions.getResponseLengthByKey("data.size()");
            System.out.print(EnvGlobals.pagesize);
            validations.PublicUser.getUser2List();


        }


    }
