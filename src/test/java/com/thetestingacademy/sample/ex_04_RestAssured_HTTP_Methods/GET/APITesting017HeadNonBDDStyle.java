package com.thetestingacademy.sample.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting017HeadNonBDDStyle {

    RequestSpecification r; //pre-request, given part
    Response response;//making request - when part
    ValidatableResponse vr;//post-request - then part
    String pincode;


    @Test
    public void test_HEAD_NonBDD(){
        //Part 1
        pincode="560048";
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //Part 2
        response = r.when().log().all().head();

        //part 3
        vr= response.then().log().all();
        vr.statusCode(200);


    }


}
