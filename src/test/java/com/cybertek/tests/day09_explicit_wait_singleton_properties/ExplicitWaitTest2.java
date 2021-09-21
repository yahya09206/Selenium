package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
public class ExplicitWaitTest2 extends TestBase {

    @Test
    public void waitUntilElementInteractive(){

        driver.get("http://practice.cybertek.com/dynamic_controls");

        // elementToBeClickable(By locator)
        // elementToBeClickable(WebElement element)
        // An exception for checking an element is visible and enabled such that you can click it

        // click on enable button and wait until input=box is enabled clickable

        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(elementToBeClickable(By.cssSelector("form#input-example>input")));
    }
}
