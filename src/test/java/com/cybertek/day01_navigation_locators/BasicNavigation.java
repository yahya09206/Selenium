package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {

        //set up chrome driver
        WebDriverManager.chromedriver().setup();
        // create chromedriver object
        WebDriver driver = new ChromeDriver();
        // navigate to https://yahoo.com
        driver.get("https://yahoo.com");
    }
}
