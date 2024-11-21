package endpoints;

public class Routes {

    public static String baseUrl = "https://petstore.swagger.io/v2";

    //User Module With Urls
    public static String postUrl = baseUrl+"/user/createWithList";
    public static String getUrl = baseUrl+"/user/{username}";
    public static String putUrl = baseUrl+"/user/{username}";
    public static String deleteUrl = baseUrl+"/user/{username}";
    public static String userLoginUrl = baseUrl+"/user/login";


    // Here you will use Store Module with Urls
    public static String getOrderByID = baseUrl + "/store/order/{orderId}";

    public static String postOrderUrl = baseUrl + "/store/order";

    public static String deleteOrderByID = baseUrl + "/store/order/{orderId}";





}
