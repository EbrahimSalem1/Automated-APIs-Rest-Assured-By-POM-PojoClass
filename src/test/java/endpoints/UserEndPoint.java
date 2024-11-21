package endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadPojo.User;
import utilities.JsonUtil;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.*;

//UserEndPoint.java
//Created for perform Create , Read . Update , Delete to the user APIs;


public class UserEndPoint {


    public static Response createUser(){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(new File("src/test/resources/jsonData/createUser.json"))
                .when()
                .post(Routes.postUrl);

        return response;
    }

    public static Response readUser(String userName){

        Response response = given()
                .pathParam("username" , userName)
                .when()
                .get(Routes.getUrl);

        return response;
    }

    public static Response updateUser(String userName) throws IOException {

        User user = JsonUtil.readJsonFromFile("src/test/resources/jsonData/updateUser.json" , User.class);

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username" , userName)
                .body(user)
                .when()
                .put(Routes.putUrl);

        return response;
    }

    public static Response deleteUser(String userName){

        Response response = given()
                .pathParam("username" , userName)
                .when()
                .delete(Routes.deleteUrl);
        return response;
    }


    public static Response loginUser(String userName , String password){
        Response response = given()
                .queryParam("username" , userName)
                .queryParam("password" , password)
                .when()
                .get(Routes.userLoginUrl);

        return response;
    }

}
