package com.cybertek.tests.day06_junit_practice_utility_methods;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

public class AlertPracticeTest extends TestBase {

    // regular(ok), confirm(ok and cancel), prompt(enter text)
    @Test
    public void testJavaScriptAlert(){

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
}
