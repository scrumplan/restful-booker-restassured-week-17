package com.herokuapp.booker.restfulinfo;

import com.herokuapp.booker.model.BookingPojo;
import com.herokuapp.booker.model.BookingPojoPatch;
import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PartiallyUpdateBooking extends TestBase {

    @Test
    public void updateBookingRecord(){
        BookingPojoPatch bookingPojo = new BookingPojoPatch();
        bookingPojo.setFirstname("Jame");
        bookingPojo.setLastname("Brown");

        Response response = given()
                .header("Cookie","token=013ee7fa73226e8")
                .header("Authorization","Bearer 0c90e41203eca75")
                .header("Content-Type","application/json")
                .pathParam("id",2605)
                .body(bookingPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
