package config;

public class EndpointURLs {

    public static final String oAuth = "/oauth/token";

///////////////////Users///////////////////
    public static final String createUser = "/api/user";
    public static final String updateUser = "/api/user";
    public static final String getUser  = "/api/user/";
    public static final String getRoles  = "/api/roles";
    public static final String getUsersList = "/api/users?q=&startIndex=0&length=10000";

    public static final String createUser2 = "/api/users";
    public static final String User2List = "/api/users?page=1";
    public static final String userLogin = "/v1/api/public/user/login";
    public static final String validUser = "/v1/api/public/user/is-valid";


}
