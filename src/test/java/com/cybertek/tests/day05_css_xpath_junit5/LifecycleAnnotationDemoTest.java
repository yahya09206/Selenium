package com.cybertek.tests.day05_css_xpath_junit5;

import org.junit.jupiter.api.*;

public class LifecycleAnnotationDemoTest {

    @BeforeAll
    public static void init(){
        System.out.println("@BeforeAll runs once before all tests");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("@BeforeEach run before each and every test");
    }

    @Test
    public void test1(){
        System.out.println("test1 message is running");
    }

    @Test
    public void test2(){
        System.out.println("test2 message is running");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("@AfterEach run after each and every test");
    }

    @AfterAll
    public static void destroy(){
        System.out.println("@AfterAll runs once after all tests");
    }
}
