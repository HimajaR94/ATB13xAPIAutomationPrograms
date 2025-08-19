package com.thetestingacademy.sample.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITestingLab06TestCase {
    String pincode;
    @Test
    public void test_tc1_pincode_valid(){
        //valid pincode - 110001
        pincode ="110001";
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

    }
    @Test
    public void test_tc2_pincode_invalid(){
        //@, #, $, % any special input
        pincode="@";
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }
    @Test
    public void test_tc3_pincode_invalid(){
        // ''Blank = pincode
        pincode=" ";
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }

}
