package com.cybertek.tests.day06_junit_practice_utility_methods;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AlertPracticeTest extends TestBase {

    // Javascript alerts are pop up that show up after you click on button
    // in certain pages, and there are 3 types of pop-up
    // regular(ok), confirm(ok and cancel), prompt(enter text)
    // confirm(ok and cancel)
    // prompt(enter text) and select ok and cancel
    @Test
    public void testJavaScriptAlert(){

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        // Alert interface from Selenium is used to deal with alerts
        // you driver object can switchTo the alert and take action on it

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
    }
}
