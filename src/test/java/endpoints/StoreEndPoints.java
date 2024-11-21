package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;

public class StoreEndPoints {

//    User user = JsonUtil.readJsonFromFile("src/test/resources/jsonData/createUser.json" , User.class);


    public static Response getOrder_ById(int orderID){
        Response response = given()
                .pathParam("orderId" , orderID)
                .when()
                .get(Routes.getOrderByID);
        return response;


    }


    public static Response PostOrder_ById(){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(new File("src/test/resources/jsonData/createStore.json"))
                .when()
                .post(Routes.postOrderUrl);
        return response;
    }


    public static Response deleteOrderByIds(int deleteOrderId){

        Response response = given()
                .pathParam("orderId" , deleteOrderId)
                .when()
                .delete(Routes.deleteOrderByID);
        return response;
    }

}
