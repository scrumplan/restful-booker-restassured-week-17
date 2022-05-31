package com.herokuapp.booker.restfulinfo;

import com.herokuapp.booker.model.BookingPojo;
import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateBookingRecord extends TestBase {

    @Test
    public void createTheBookingRecord(){
        HashMap<String,String> dates= new HashMap<>();
        dates.put("checkin","2021-09-11");
        dates.put("checkout","2022-05-11");
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Mathur");
        bookingPojo.setLastname("male");
        bookingPojo.setTotalprice(20000);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(dates);
        bookingPojo.setAdditionalneeds("any");

        Response response = given()
                .header("Content-Type","application/json")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
