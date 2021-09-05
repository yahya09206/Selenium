package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDryRun {
    public static void main(String[] args) {

        //1. setup chrome driver using web driver manager
            // so selenium can send interaction request
        WebDriverManager.chromedriver().setup();

        //2. create web driver instance using chrome driver object
        WebDriver driver = new ChromeDriver();

        //3. navigate to google.com
        driver.get("https://google.com");


    }
}
