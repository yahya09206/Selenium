package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.Driver;
import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.Test;

public class WebOrderLoginTests {

    @Test
    public void testLoginWithCorrectCredentials(){

        // go to login page
        WebOrderUtility.openWebOrderApp();
        // login with correct credentials
        WebOrderUtility.login("Tester", "test");

        // get title
        String pageTitle = Driver.getDriver().getTitle();
        // check if at all orders page
        if (Driver.getDriver().getTitle().equals("Web Orders")){
            System.out.println("You are on the correct page " + pageTitle);
        }
    }

}
