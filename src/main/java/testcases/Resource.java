package testcases;
import config.ConfigProperties;
import config.EndpointURLs;
import config.EnvGlobals;
import config.ReusableFunctions;
import general.BaseTest;
import org.testng.annotations.Test;

import java.io.File;

public class Resource extends BaseTest {

    @Test
    public void uploadResourceImage()
    {

        ReusableFunctions.givenHeaderFormData(ReusableFunctions.headers(), ReusableFunctions.form_data("file", new File(ConfigProperties.filePath + "/profileImage.png")));
        ReusableFunctions.whenFunction("post", ConfigProperties.baseUrl +EnvGlobals.version+EndpointURLs.imageUpload);
        ReusableFunctions.thenFunction(200);
        validations.ResourceImage.verifyImageUpload();


    }
}