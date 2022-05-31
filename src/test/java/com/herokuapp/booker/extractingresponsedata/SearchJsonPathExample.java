package com.herokuapp.booker.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking")
                .then().statusCode(200);


    }
    //1] extract status Code , time , status = ok
    @Test
    public void test001(){
        System.out.println("Status Code is : " + response.extract().statusCode());
        System.out.println("Response Time is : " +response.extract().time());
        System.out.println("Status OK is : " +response.extract().statusLine());
    }


}
