package com.thetestingacademy.sample.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014NonBDDPatchtoken {

    //PUT
    //Toke, booking id
    //public void get_token()
    //public void get_booking_id()

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_patch_nonbdd(){
        String bookingid="3107";
        String token="111291c31055984";

        String payload= "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.cookie("token",token);
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response=r.when().log().all().patch();

        vr=response.then().log().all().statusCode(200);



    }

}
