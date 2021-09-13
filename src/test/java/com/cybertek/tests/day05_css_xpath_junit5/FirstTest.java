package com.cybertek.tests.day05_css_xpath_junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest {
    // Test method is annotated with @Test annotation
    // It is a void method with no param
    @Test
    public void testAddition(){

        int num1 = 10;
        int num2 = 7;
        int expectedResult = 17;
        Assertions.assertEquals(expectedResult, num1 + num2);
    }

    @Test
    public void testString(){

        String msg = "I love Selenium";

    }


}
