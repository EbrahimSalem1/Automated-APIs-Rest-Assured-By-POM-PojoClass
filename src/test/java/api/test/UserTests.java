package api.test;

import com.github.javafaker.Faker;
import endpoints.UserEndPoint;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloadPojo.User;
import utilities.JsonUtil;
import utilities.Logs;

import java.io.IOException;

import static utilities.DataDriven.JsonClass.readJson;

public class UserTests {


    @Test(priority = 1)
    public void testPostUser(){

        Logs.info("testCreate Users...");
        Response response = UserEndPoint.createUser();
        response.then().log().all();
        Logs.info("Assert on created Users with status code");
        Assert.assertEquals(response.getStatusCode() , 200);




        //Checking Fetching Data After CreatedUser
        Response responseAfterCreated = UserEndPoint.readUser("Ibrahim1");
        responseAfterCreated.then().log().all();
        Assert.assertEquals(responseAfterCreated.getStatusCode() , 200);

    }

    @Test(priority = 2)
    public void testUserLoginByUserNameAndPassword(){
        Logs.info("Starting test Login UserByNameAndPassword...");
        Response response = UserEndPoint.loginUser("Ibrahim1" , "kfvnbvslhe734@!_+ef");
        response.then().log().all();
        Logs.info("Assert on Logged-in Users with status code...");
        Assert.assertEquals(response.getStatusCode() , 200);

    }


    @Test(priority = 3)
    public void testGetUserByName(){
        Logs.info("Starting testGetUserByName...");
        Response response = UserEndPoint.readUser("Ibrahim1");
        response.then().log().all();
        Logs.info("Assert on UserName with status code...");
        Assert.assertEquals(response.getStatusCode() , 200);
    }

   @Test(priority = 4)
    public void testUpdateUserByName() throws IOException {
       Logs.info("Starting testUpdateUserByName...");
        Response response = UserEndPoint.updateUser("username");
        response.then().log().all();
       Logs.info("Assert on updated UserName status code");
        Assert.assertEquals(response.getStatusCode() , 200);

        ////Checking Fetching Data After UpdatedUser
        Response responseGetData = UserEndPoint.readUser("IbrahimSpecialOne11");
        responseGetData.then().log().all();
        Assert.assertEquals(responseGetData.getStatusCode() , 200);
    }

    @Test(priority = 5)
    public void testDeleteUser(){
        Logs.info("Starting testDeleteUserByName...");
        Response response = UserEndPoint.deleteUser("IbrahimSpecialOne11");
        response.then().log().all();
        Logs.info("Assert on Deleted UserName with status code");
        Assert.assertEquals(response.getStatusCode() , 200);
        Logs.info("Finished testDeleted UserName...");
    }


}