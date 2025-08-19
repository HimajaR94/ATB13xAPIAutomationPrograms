package com.thetestingacademy.sample.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012NonBDDPut {

    //PUT
    //Toke, booking id
    //public void get_token()
    //public void get_booking_id()

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_nonbdd(){
        String bookingid="3011";
        String token="978c94079f6230d";

        String payload= "{\n" +
                "    \"firstname\" : \"Himaja\",\n" +
                "    \"lastname\" : \"R\",\n" +
                "    \"totalprice\" : 2000,\n" +
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
