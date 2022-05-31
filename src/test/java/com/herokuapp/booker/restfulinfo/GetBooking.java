package com.herokuapp.booker.restfulinfo;

import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBooking extends TestBase {
    @Test
    public void getAllBookingRecord(){
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getBookingRecordByGivenId(){
        Response response = given()
                .header("Authorization","Bearer 0c90e41203eca75")
                .pathParam("id",1199)
                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
