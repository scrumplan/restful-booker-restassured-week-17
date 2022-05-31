package com.herokuapp.booker.myfirsttest;


import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by Jay Vaghani
 */
public class MyFirstTest extends TestBase {

    @Test
    public void getAllReqresInfo() {

        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
