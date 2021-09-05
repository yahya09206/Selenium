package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagingBrowserWindow {
    public static void main(String[] args) {

        // set up chrome driver
        WebDriverManager.chromedriver().setup();
        // create chrome driver object
        WebDriver driver = new ChromeDriver();


        // maximize the browser window

        // make the browser window full screen

        // quit the browser
    }
}
