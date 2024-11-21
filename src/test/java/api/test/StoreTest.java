package api.test;
import endpoints.StoreEndPoints;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Logs;

import static org.hamcrest.Matchers.*;

public class StoreTest {




    @Test
    public void testCreateAOrder(){

        //Positive
        Logs.info("testCreateOrderByID...");
        Response response  = StoreEndPoints.PostOrder_ById();
        response.then().log().all();
        Logs.info("Assert on createdOrderByID with status code");
        Assert.assertEquals(response.getStatusCode() , 200);
//      response.then().assertThat().body("id" , equalTo(100));

        //Negative
        Response dataAfterCreatedNewOrder = StoreEndPoints.PostOrder_ById();
        dataAfterCreatedNewOrder.then().log();
        Assert.assertNotEquals(dataAfterCreatedNewOrder.getStatusCode() , 201);

    }


    @Test
    public void testGetOrderByID(){

        //Positive
        Logs.info("Starting testGetPetByValidID...");
        Response response = StoreEndPoints.getOrder_ById(100);
        response.then().log().all();
        Logs.info("Assert on get pey by valid id status code");
        Assert.assertNotEquals(response.getStatusCode() , 201);

        //Negative
        Response dataAfterGetOrderID = StoreEndPoints.getOrder_ById(100);
        dataAfterGetOrderID.then().log();
        Assert.assertEquals(dataAfterGetOrderID.getStatusCode() , 200);
    }

    @Test
    public void testDeleteAnOrderByID(){

        //Positive
        Logs.info("testDeleteOrderByID...");
        Response response = StoreEndPoints.deleteOrderByIds(12);
        response.then().log().all();
        Logs.info("Assert on deleteOrderById with status code");
        Assert.assertNotEquals(response.getStatusCode() , 200);

        //Negative
        Logs.info("testGetOrderByID After Deleted...");
        Response dataAfterDeleted =  StoreEndPoints.getOrder_ById(12);
        dataAfterDeleted.then().log().all();
        Logs.info("Assert on deleteOrderById with status code ");
        Assert.assertEquals(dataAfterDeleted.getStatusCode() , 404);

    }

}
