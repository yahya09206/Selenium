package com.cybertek.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Driver utility class to give us single Webdriver instance
public class Driver {

    // private static field
    private static WebDriver obj;
    // private constructor
    private Driver(){ };


    // getter with conditional object creation
    public static WebDriver getDriver(){

        String browserName =
        // check if object is null
        if (obj == null){
            // set up chrome driver
            WebDriverManager.chromedriver().setup();
            obj = new ChromeDriver();
            obj.manage().window().maximize();
            // return obj that will be created only once each time
            return obj;
        }else {
            // if object already exist then just return it
            return obj;
        }
    }

    public static void closeBrowser(){

        // check if there is driver
        // basically checking if obj is null or not
        // if not null
            // quit the browser
            // make it null, because once quit it can not be used
        if (obj != null){
            obj.quit();
            obj = null;
        }
    }

}
