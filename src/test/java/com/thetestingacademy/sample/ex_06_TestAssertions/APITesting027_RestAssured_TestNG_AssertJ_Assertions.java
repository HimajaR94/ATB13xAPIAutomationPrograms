package com.thetestingacademy.sample.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test

    public void test_createBooking_POST() {
        //payload
        String payload = "{\n" +
                "    \"firstname\" : \"Himaja\",\n" +
                "    \"lastname\" : \"R\",\n" +
                "    \"totalprice\" : 2000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-23\",\n" +
                "        \"checkout\" : \"2025-01-25\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        //given - setting up the body, url, basepath, uri
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        //headers
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();
        //when - making the request
        response = requestSpecification.when().post();
        //then - extraction and then validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        //booking id!= null, first name is himaja

        //System.out.println(response.asString());

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Himaja"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("R"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));

        bookingId=validatableResponse.extract().path("bookingid");
        String firstname=validatableResponse.extract().path("booking.firstname");
        String lastname=validatableResponse.extract().path("booking.lastname");
        boolean depositpaid=validatableResponse.extract().path("booking.depositpaid");
        //Another mechanism to extract json path
        JsonPath jp= new JsonPath(response.asString());
        Integer bookingID1= jp.getInt("bookingid");




        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Himaja");
        Assert.assertEquals(lastname,"R");
        Assert.assertTrue(depositpaid,"deposit paid is true");

        if(!firstname.contains("Himaja")){
            Assert.fail("fail the test");
        }


        //AssertJ (3rd party Library for Assertions)-20%

        assertThat(bookingId).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isNotNull().isNotEmpty().isNotBlank().isEqualTo("Himaja");
        assertThat(depositpaid).isTrue();

        assertThat(jp.getInt("bookingid")).isNotZero().isNotNull().isPositive();
        assertThat(jp.getString("booking.firstname")).isNotNull().isNotBlank().isNotEmpty().isEqualTo("Himaja");




    }

}
