package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_ManagingBrowserWindow {
    public static void main(String[] args) {

        //Set up chrome and create webdriver instance
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        //maximize window
        driver.manage().window().maximize();
        //full screen
        //driver.manage().window().fullscreen();
        //set the position of the window by providing from top and left offset
        driver.manage().window().setPosition( new Point(300, 0));

        //get the current position of the window
        System.out.println("driver.manage().window().getPosition() = " +
                            driver.manage().window().getPosition());

        System.out.println("THE END");
    }
}
