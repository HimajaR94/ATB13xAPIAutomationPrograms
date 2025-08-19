package com.thetestingacademy.sample.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009NonBDDStyle {

    RequestSpecification r; //pre-request, given part
    Response response;//making request - when part
    ValidatableResponse vr;//post-request - then part
    String pincode;


    @Test
    public void test_GET_NonBDD(){
        //Part 1
        pincode="560048";
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //Part 2
        response = r.when().log().all().get();

        //part 3
        vr= response.then().log().all();
        vr.statusCode(200);


    }
    @Test
    public void test_GET_NonBDD_Negative(){
        pincode ="@";

        //Given
        r=RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);
        //When
        response=r.when().log().all().get();
        //Then
        vr=response.then().log().all();
        vr.statusCode(404);

    }

}
