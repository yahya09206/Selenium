package com.cybertek.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

/**
 * This class is meant to be super class
 * to provide driver set up and closing browser
 * for it's subclasses
 */

public abstract class TestBase {

    protected WebDriver driver;

    // setting up all driver stuff here directly in @BeforeEach method
    @BeforeEach
    public void setupWebDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver = WebDriverFactory.getDriver("firefox");
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
