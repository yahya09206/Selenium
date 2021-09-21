package com.cybertek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// This isn't a test class so we can not extend testbase
// it simply doesnt not make sense
public class WebOrderUtility{

    public static void login(WebDriver driverParam){

        // BELOW LINE WILL NOT WORK BECASUE IT WILL OPEN NEW DRIVER EACH TIME
        // WebDriver driver = WebDriverFactory.getDriver("chrome");
        // enter username
        driverParam.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        // enter password
        driverParam.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        // click login
        driverParam.findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    public static void login(WebDriver driverParam, String username, String password){

        // BELOW LINE WILL NOT WORK BECASUE IT WILL OPEN NEW DRIVER EACH TIME
        // WebDriver driver = WebDriverFactory.getDriver("chrome");
        // enter username
        driverParam.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        // enter password
        driverParam.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        // click login
        driverParam.findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    public static void logout(){

    }
}
