package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorTest extends TestBase {

    @Test
    public void testScrollWholeWindow(){

        // navigate to infinite scroll page
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        // scroll by 1000px down, no need for left and right scroll
        BrowserUtil.waitFor(2);
        // get JavaScriptExecutor reference from driver variable
        // so we can run this js code windows.scrollBy(0, 1000)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // it uses execute method to run javascript, it can accept parameter
        jse.executeScript("window.scrollBy(0,1000)");

        // scrolling once is not obvious, let's loop and scroll 10 times and wait 1 second in between
        for (int i = 1; i <= 10; i++){
            jse.executeScript("window.scrollBy(0,1000)");
            BrowserUtil.waitFor(1);
        }

        BrowserUtil.waitFor(4);
    }

    @Test
    public void testScrollElementIntoView(){

        // navigate to
        driver.get("http://practice.cybertekschool.com/large");
        // locate cybertekSchooLnk and homeLnk

        // get jse
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // run this javascript to scroll the element into the view
        // theElementIdentified.scrollIntoView(true)
        // in order to pass our element into above method
        // we need to use arguments[specify index here]
        // whatever we pass to executeScript method after javascript code will be argument with index


        // try out passing argument in window.scrollBy(0,1000)
        // I want to pass this 1000 externally when i call the method
        int myScrollNumber = 1000;
        jse.executeScript("window.scrollBy(0, arguments[0])", myScrollNumber);

        // now call arguments[0].scrollIntoView(true)
        WebElement cybertekSchoolLink = driver.findElement(By.linkText("Cybertek School"));

        jse.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink);
    }
}
