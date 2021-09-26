package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.Driver;
import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
//        if (Driver.getDriver().getTitle().equals("Web Orders")){
//            System.out.println("You are on the correct page " + pageTitle);
//        }else {
//            System.out.println("You are not on the correct page " + Driver.getDriver().getTitle());
//        }
        assertTrue(WebOrderUtility.isAtOrderPage());

        // check if username matches
//        if (actualName.contains("Tester")){
//            System.out.println("Username matches " + actualName);
//        }else {
//            System.out.println("Names don't match");
//        }
        assertTrue(WebOrderUtility.verifyUserName("Tester"));
    }

    @Test
    public void testLoginWithInvalidCredentials(){

        // go to login page
        WebOrderUtility.openWebOrderApp();
        // login with correct credentials
        WebOrderUtility.login("Test", "test");

        // get title
        String pageTitle = Driver.getDriver().getTitle();

        // check if still on login page
        if (Driver.getDriver().getTitle().equals("Web Orders Login")){
            System.out.println("You are on the correct page " + pageTitle);
        }else {
            System.out.println("You are not on the correct page " + pageTitle);
        }

        WebElement errorMsg = Driver.getDriver().findElement(By.xpath("//span"));
        String expectedMsg = "Invalid Login or Password";
        String actualMsg = errorMsg.getText();

        if (actualMsg.contains("Invalid Login or Password")){
            System.out.println("Displaying correct message");
        }else {
            System.out.println("Not displaying correct message");
        }
    }

}
