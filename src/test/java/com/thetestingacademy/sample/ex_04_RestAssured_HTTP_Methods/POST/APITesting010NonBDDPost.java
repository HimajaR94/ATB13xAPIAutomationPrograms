package com.thetestingacademy.sample.ex_04_RestAssured_HTTP_Methods.POST;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class APITesting010NonBDDPost {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_Post_NonBDD_CreateToken(){

        //URL https://restful-booker.herokuapp.com/auth
        //Payload {
        //    "username" : "admin",
        //    "password" : "password123"
        //}

        //Header Content-Type: application/json
        //Auth?
        //Cookie?
        //Validate - 200OK
        //Body Response - Token is generated or not

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        System.out.println("----------Part 1----------");
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        System.out.println("----------Part 2-----------");
        //Making HTTP Request --> Part 2
        response=r.when().log().all().post();

        System.out.println("----------Part 3-----------");
        //Verification Part -> Part 3
        vr=response.then().log().all();
        vr.statusCode(200);

    }
}
