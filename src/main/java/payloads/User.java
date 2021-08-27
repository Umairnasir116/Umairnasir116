package payloads;

public class User {


    public static String userLogin(String email , String password) {
        return "{\n" +
                "\t\"email\": \""+email+"\",\n" +
                "\t\"password\": \""+password+"\"\n" +
                "}";
    }
    public static String validUser(String token) {
        return "{\n" +
                "\t\"accessToken\": \""+token+"\"\n" +
                "}";
    }







}
