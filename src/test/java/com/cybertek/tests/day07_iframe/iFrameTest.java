package com.cybertek.tests.day07_iframe;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameTest extends TestBase {

    @Test
    public void testSimpleIFrame(){
        driver.get("http://practice.cybertekschool.com/iframe");

        // first need to swith to iframe
        driver.switchTo().frame()

        // locate the <p> element inside iframe
        WebElement pTaginsideFrame = driver.findElement(By.tagName("p"));
        System.out.println("pTaginsideFrame.getText() = " + pTaginsideFrame.getText());

    }

}
