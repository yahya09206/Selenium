package com.cybertek.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    // private static field
    private static WebDriver obj;
    // private constructor
    private Driver(){ };

    // getter with conditional object creation
    public static WebDriver getDriver(){

        // check if object is null
        if (obj == null){
            // set up chrome driver
            WebDriverManager.chromedriver().setup();
            obj = new ChromeDriver();
            obj.manage().window().maximize();
        }
    }
}
