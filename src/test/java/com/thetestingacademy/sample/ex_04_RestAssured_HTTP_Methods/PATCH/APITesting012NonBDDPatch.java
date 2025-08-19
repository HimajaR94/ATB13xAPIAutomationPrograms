package com.thetestingacademy.sample.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012NonBDDPatch {

    //PUT
    //Toke, booking id
    //public void get_token()
    //public void get_booking_id()

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_nonbdd(){
        String bookingid="2301";


        String payload= "{\n" +
                "    \"firstname\" : \"Himaja\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response=r.when().log().all().patch();

        vr=response.then().log().all().statusCode(200);



    }

}
