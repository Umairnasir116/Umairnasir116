/*
# Get properties values and set into variables
*/
package config;
/*
# Get properties values and set into variables
*/

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

import java.util.ArrayList;

import static org.testng.util.Strings.isNullOrEmpty;



@Classpath({"ApplicationConfig.properties"})

public class ApplicationConfigReader {

    @Property("authUrl")
    private String authUrl;

    @Property("baseUrl")
    private String baseUrl;

    @Property("username")
    private String UserName;

    @Property("email")
    private String email;

    @Property("password")
    private String Password;

    @Property("Environment")
    private String Environment;

    @Property("Project")
    private String Project;

    @Property("port")
    private String Port;

    @Property("isEnableReporting")
    private String isEnableReporting;

    @Property("dbUrl")
    private String dbUrl;

    @Property("dbUserName")
    private String dbUserName;

    @Property("grantType")
    private String grantType;

    @Property("clientId")
    private String clientId;

    @Property("dbPassword")
    private String dbPassword;

    @Property("apiVersion")
    private String apiVersion;

    @Property("filePath")
    private String sheetPath;

    @Property("resourcesBaseUrl")
    private String resourcesBaseUrl;

    @Property("resourcesserverPort")
    private String resourcesserverPort;

    @Property("publicUserLogin")
    private String publicUserLogin;

    @Property("userPhoneNo")
    private String userPhoneNo;

    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }


    public String getGrantType() {
        return grantType;
    }

    public String getClientId() {
        return clientId;
    }
    public String getDbUrl() {
        //return !isNullOrEmpty(dbUrl) ? dbUrl : System.getenv("dbUrl");
        return !isNullOrEmpty(this.dbUrl) ? this.dbUrl : System.getenv("TestRailToken");

    }
    public String getDbUsername() {
        return !isNullOrEmpty(dbUserName) ? dbUserName : System.getenv("dbUserName");
    }
    public String getDbPassword() {
        return !isNullOrEmpty(dbPassword) ? dbPassword : System.getenv("dbPassword");
    }
    public String getBaseUrl() {
        return this.baseUrl;
    }
    public String getUserName() {
        return this.UserName;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.Password;
    }
    public String getEnvironment() {
        return this.Environment;
    }
    public String getProject() {
        return this.Project;
    }
    public String getPort() {
        return this.Port;
    }
    public String getIsEnableReporting() {
        return this.isEnableReporting;
    }
    public String getAuthUrl() { return authUrl; }
    public String getResourcesBaseUrl()
        {
        return this.resourcesBaseUrl;
    }

    public String getpublicUserLogin() { return publicUserLogin; }
    public String getresourcesserverPort() {
        return this.resourcesserverPort;
    }
    public String getUserPhoneNo()
    {
        return this.userPhoneNo;
    }
    public String getFilePath() {
        return System.getProperty("user.dir") + "/files";
    }

}