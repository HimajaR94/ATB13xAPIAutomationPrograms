package com.thetestingacademy.sample.ex_05_TestNGExamples.parallel.test_level;

import org.testng.annotations.Test;

public class APISmoke {
    @Test
    public void test_APISmoke(){
        System.out.println("Thread id:"+Thread.currentThread().getId());
    }
}
