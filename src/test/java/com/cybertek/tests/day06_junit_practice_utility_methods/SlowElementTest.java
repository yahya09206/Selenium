package com.cybertek.tests.day06_junit_practice_utility_methods;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SlowElementTest extends TestBase {

    @Test
    public void testWait() {

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // we can instruct web driver to wait maximum amount of time
        // before throwing NoSuchElement Exception by using implicit wait
        // If element is not available, it will wait for maximum of 10seconds
        // If element is found before 10s for example 1 second --> It will move on to next step

        driver.navigate().to("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        WebElement itsGoneElm = driver.findElement(By.id("message"));
        System.out.println("itsGoneElm.getText() = " + itsGoneElm.getText());
        System.out.println("THE END");
    }
}
