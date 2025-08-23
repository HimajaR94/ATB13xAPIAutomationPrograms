package com.thetestingacademy.sample.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameter {

    @Test
    @Parameters("Browser")
    public void demo(String value){
        System.out.println("I am demo");
        System.out.println("You are running example of testNG parameters");

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Starting the firefox");
        }
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Starting the Chrome");
        }
    }
}
