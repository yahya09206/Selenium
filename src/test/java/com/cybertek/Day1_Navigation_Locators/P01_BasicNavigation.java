package com.cybertek.Day1_Navigation_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_BasicNavigation {
    public static void main(String[] args) {
        //Set up chrome and create Webdrive instance
        WebDriverManager.chromedriver().setup();
        //Create chrome driver object
        WebDriver driver = new ChromeDriver();

        //driver.get(url)
        driver.get("https://google.com");
        //driver.navigate.back()
        driver.navigate().back();
        //drive.navigate.refresh
        driver.navigate().refresh();
    }
}
