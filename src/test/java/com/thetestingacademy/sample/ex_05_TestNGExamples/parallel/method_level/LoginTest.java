package com.thetestingacademy.sample.ex_05_TestNGExamples.parallel.method_level;

import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void validLogin(){
        System.out.println("ValidLogin - Thread"+Thread.currentThread().getId());
    }
    @Test
    public void invalidLogin(){
        System.out.println("InvalidLogin - Thread"+Thread.currentThread().getId());
    }
}
