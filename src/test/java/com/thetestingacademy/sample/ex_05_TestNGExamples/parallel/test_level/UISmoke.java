package com.thetestingacademy.sample.ex_05_TestNGExamples.parallel.test_level;

import org.testng.annotations.Test;

public class UISmoke {

    @Test
    public void test_UISmoke(){
        System.out.println("Thread id:"+Thread.currentThread().getId());
    }
}
