package com.herokuapp.booker.restfulinfo;

import com.herokuapp.booker.model.BookingPojo;
import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateBookingRecord extends TestBase {

    @Test
    public void UpdateTheBookingRecord(){
        HashMap<String,String> dates= new HashMap<>();
        dates.put("checkin","2018-01-01");
        dates.put("checkout","2019-01-01");
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Jim");
        bookingPojo.setLastname("Brown");
        bookingPojo.setTotalprice(111);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(dates);
        bookingPojo.setAdditionalneeds("any");

        Response response = given()
                .header("Cookie","token=013ee7fa73226e8")
                .header("Authorization","Bearer 0c90e41203eca75")
                .header("Content-Type","application/json")
                .pathParam("id",4953)
                .body(bookingPojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
