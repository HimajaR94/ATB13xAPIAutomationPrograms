package com.thetestingacademy.sample.ex_05_TestNGExamples.parallel.class_level_cross_browser_Testing;

import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    public void test_Firefox(){
        System.out.println("2");
        System.out.println("Thread id:"+Thread.currentThread().getId());
    }
}
