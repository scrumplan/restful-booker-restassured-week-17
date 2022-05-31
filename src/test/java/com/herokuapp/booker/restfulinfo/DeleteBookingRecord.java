package com.herokuapp.booker.restfulinfo;

import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingRecord extends TestBase {

    @Test
    public void deleteTheBookingRecord(){
        Response response = given()
                .header("Cookie","token=013ee7fa73226e8")
               // .header("Authorization","Bearer 0c90e41203eca75")
                .pathParam("id",808)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
