package com.thetestingacademy.sample.ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

//    @Test
//    public void test_hardAssertionExample(){
//        System.out.println("start of the program");
//        Assert.assertEquals("Himaja","himaja");
//        System.out.println("end of the program");
//    }


    @Test
    public void test_softAssertionExample(){
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals("Himaja","himaja");
        System.out.println("end of the program");
        softAssert.assertAll();
    }


}
