package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.Driver;
import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebOrderLoginTests {

    @Test
    public void testLoginWithCorrectCredentials(){

        // go to login page
        WebOrderUtility.openWebOrderApp();
        // login with correct credentials
        WebOrderUtility.login("Tester", "test");

        // get title
        String pageTitle = Driver.getDriver().getTitle();
        // get username
        WebElement userName = Driver.getDriver().findElement(By.xpath("//div[@class='login_info']"));
        String expectName = "Tester";
        String actualName = userName.getText();
        // check if at all orders page
        if (Driver.getDriver().getTitle().equals("Web Orders")){
            System.out.println("You are on the correct page " + pageTitle);
        }else {
            System.out.println("You are not on the correct page " + Driver.getDriver().getTitle());
        }

        // check if username matches
        if (actualName.contains("Tester")){
            System.out.println("Username matches " + actualName);
        }else {
            System.out.println("Names don't match");
        }
    }

}
