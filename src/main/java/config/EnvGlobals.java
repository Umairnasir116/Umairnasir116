/*
Define global variables to use re-use them
 */

package config;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EnvGlobals {


    public static StringBuilder Differnce = new StringBuilder() ;


    public static Response response; // API response object
    public static RequestSpecification requestSpecification; // given store object
    public static String version = "/v1";
    public static String basicAccessToken = "Basic cHVibGljOnB1YmxpYw==";
    public static String appbasicToken = "Basic bW9iaWxlLWFwcDpkYjUwNjk2YS03MjViLTExZWEtYmM1NS0wMjQyYWMxMzAwMDM=";
    public static String authorizationToken; // authorization key with bearer
    public static int interestLength;
    public static String EmailuserId;
    public static String emailPrincipleName;
    public static String PhoneprincipleName;
    public static String updatephoneuserResponse;
    public static String updateEmailuserResponse;
    public static String PhoneuserId;
    public static String userId;
    public static int pagesize;
}
