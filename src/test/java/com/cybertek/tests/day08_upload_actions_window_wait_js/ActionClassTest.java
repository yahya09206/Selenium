package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassTest extends TestBase {

    @Test
    public void testHoverAction(){
        /**
         * get first image
         * (//div[@class='example']/div/img)[1]
         * */
        driver.get("http://practice.cybertekschool.com/hovers");

        // locate first image and hover over to the image and verify user profile 1 displayed
        WebElement img1Elm = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));

        // Create instance of Action class by passing driver object
        Actions actions = new Actions(driver);
        actions.moveToElement(img1Elm).perform();

        BrowserUtil.waitFor(3);
    }
}
