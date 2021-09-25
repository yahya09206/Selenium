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

    public static void openWebOrderApp(){

        getDriver().navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
    }
}
