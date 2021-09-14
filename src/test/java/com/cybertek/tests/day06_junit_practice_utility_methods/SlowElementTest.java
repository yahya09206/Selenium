package com.cybertek.tests.day06_junit_practice_utility_methods;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SlowElementTest extends TestBase {

    @Test
    public void testWait(){

        driver.navigate().to("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        WebElement itsGoneElm = driver.findElement(By.id("message"));
        System.out.println("itsGoneElm.getText() = " + itsGoneElm.getText());
    }
}
