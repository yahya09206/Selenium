package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowTest extends TestBase {

    @Test
    public void testWindowOrTab(){

        // selenium see window or tab
        // everything is window for selenium
        driver.get("http://practice.cybertekschool.com/windows");

        // save windowHandle of this tab into currentHandle variable
        String currentHandle = driver.getWindowHandle();
        System.out.println("currentHandle = " + currentHandle);

        // try to use getWindowHandles method and print it out
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles);

        // click on the link to generate new tab/window
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        // now print out current and all window handles
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        // print out all window handles
        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());
    }
}
