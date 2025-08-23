package com.thetestingacademy.sample.ex_05_TestNGExamples.parallel.class_level_cross_browser_Testing;

import org.testng.annotations.Test;

public class ChromeTest {
    @Test
    public void test_chrome(){
        System.out.println("1");
        System.out.println("Thread id:"+Thread.currentThread().getId());

    }

}
