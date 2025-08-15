package com.thetestingacademy.sample.ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting_Lab02_RA {
    public static void main(String[] args) {
        //Gherkins Syntax
        //Given() -> Pre requisites - URL, Authentication, headers, Body
        //When() -> which HTTP Method to send the request - GET/PUT/POST/PATCH/DELETE
        //Then() -> Validation -> 200 Ok, First name == Pramod (if we need to validate anything igit n the response

        //Full URL: https://api.zippopotam.us/IN/560016
        //Base URL: https://api.zippopotam.us
        //Path URL: /IN/560016

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the pincode");
        String pincode=sc.next();

        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

    }
}
