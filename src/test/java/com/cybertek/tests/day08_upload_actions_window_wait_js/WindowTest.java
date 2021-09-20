package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
        // after you click now you have 2 tabs
        // in order to get all of them, you can call driver.getWindowHandles()
        // and we can print it out
        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());

        // our objective is to iterate over each and every handle
        // and use switch method to switch to the window
        // print out its title
        // this is reassigning the variable to new handles
        allHandles = driver.getWindowHandles(); // this will give the latest handles

        // iterate over Collection, you can use for each loop
        for(String eachHandle : allHandles){
            System.out.println("eachHandle = " + eachHandle);
            // this is how you switch to different window
            driver.switchTo().window(eachHandle);
            // now we can print out the title so we know what tab we are in right now
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        // at the end of execution we observed
        // last switched window was window with the title "New Window"
        // now we want to go back to original tab so we can continue to work on it
        System.out.println("Switching back to original tab");
        driver.switchTo().window(currentHandle);
        // assert the title is now "Practice"
        assertEquals("Practice", driver.getTitle());

    }
}
