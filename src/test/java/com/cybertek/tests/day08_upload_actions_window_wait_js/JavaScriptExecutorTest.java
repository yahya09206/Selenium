package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExecutorTest extends TestBase {

    @Test
    public void testScrollWholeWindow(){

        // navigate to infinite scroll page
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        // scroll by 1000px down, no need for left and right scroll

        // get JavaScriptExecutor reference from driver variable
        // so we can run this js code windows.scrollBy(0, 1000)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // it uses execute method to run javascript, it can accept parameter
        jse.executeScript("window.scrollBy(0,1000)");

        BrowserUtil.waitFor(4);
    }
}
