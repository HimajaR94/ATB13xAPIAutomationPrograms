package com.thetestingacademy.sample.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Groups {

    //Regression --> all the three test cases should run=3
    //smoke -> only smoke test case should run=1
    //sanity --> only sanity test cases should run =1
    @Test (groups = {"reg","sanity"})
    public void test_sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test (groups = {"reg","smoke"})
    public void test_smokeRun(){
        System.out.println("Smoke");

        Assert.assertTrue(true);

    }
    @Test (groups = {"reg"})
    public void test_regRun(){
        System.out.println("Regression");

        Assert.assertTrue(true);
    }

}
