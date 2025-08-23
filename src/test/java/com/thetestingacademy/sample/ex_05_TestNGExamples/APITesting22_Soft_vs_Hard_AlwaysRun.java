package com.thetestingacademy.sample.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting22_Soft_vs_Hard_AlwaysRun {

    @Test

    public void login(){

    }
    @Test (dependsOnMethods = "login")
    public  void placeOrder(){
        /* runs only if login passed */
        //Hard dependency

    }
    @Test(dependsOnMethods = "login", alwaysRun = true)
    public void closeBrowser(){        //Soft dependency

    /* runs even if login failed */
    }
}
