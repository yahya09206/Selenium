package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDryRun {

    public static void main(String[] args) {

        //1. Setup Chrome Driver so Selenium can use it to automate Chrome
        WebDriverManager.chromedriver().setup();
        //2. Create Chrome Driver Object to open Browser
        WebDriver driver = new ChromeDriver();
        //3. Navigate to https://google.com
        driver.navigate().to("https:google.com");
    }
}
