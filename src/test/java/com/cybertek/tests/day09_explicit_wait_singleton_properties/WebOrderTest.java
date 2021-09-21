package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.Test;

public class WebOrderTest extends TestBase {

    @Test
    public void testLogin(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

//        // enter username
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//        // enter password
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
//        // enterlogin
//        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        WebOrderUtility.login(driver);

        BrowserUtil.waitFor(4);

        // Create a class called WebOrderUtility
        // Create a static method called
        // login(username, password) accept 2 string for username password
    }
}
