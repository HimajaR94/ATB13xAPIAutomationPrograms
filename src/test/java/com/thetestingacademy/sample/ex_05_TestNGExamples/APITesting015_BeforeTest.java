package com.thetestingacademy.sample.ex_05_TestNGExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015_BeforeTest {
    //PUT Request
    // 1. getToken
    // 2. getBooking id
    // 3. test_PUT (which uses above two methods
    // 4. Close all things
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    String bookingid;
    @BeforeTest
    public void getToken(){

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();


        response=r.when().log().all().post();


        vr=response.then().log().all();
        vr.statusCode(200);
        token=response.jsonPath().getString("token");

    }
    @BeforeTest
    public void getBookingid(){
        String payload="{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"R\",\n" +
                "    \"totalprice\" : 2000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-23\",\n" +
                "        \"checkout\" : \"2025-01-25\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response=r.when().log().all().post();

        vr=response.then().log().all();
        vr.statusCode(200);
        bookingid= String.valueOf(response.jsonPath().getInt("bookingid"));
        System.out.println("Booking id: "+bookingid);

    }
    @Test
    public void test_PUT(){
        String payload= "{\n" +
                "    \"firstname\" : \"Himaja\",\n" +
                "    \"lastname\" : \"R\",\n" +
                "    \"totalprice\" : 2500,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.cookie("token",token);
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response=r.when().log().all().put();

        vr=response.then().log().all().statusCode(200);
    }



}
