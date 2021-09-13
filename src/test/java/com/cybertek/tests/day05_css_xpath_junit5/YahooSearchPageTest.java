package com.cybertek.tests.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YahooSearchPageTest {

    // write 2 tests:
    // testYahooSearchHomePageTitle
    // navigate to https://search.yahoo.com
    // test when you navigate to yahoo search page
        // the title should be "Yahoo Search - Web Search"
    @Test
    public void testYahooSearchHomePageTitle(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://search.yahoo.com/");

        String expectedTitle = "https://search.yahoo.com/";
        String actualTitle = driver.getTitle();

        // quit browser
        driver.quit();

        // do static import so you can do this
        // import static org.junit.jupiter.api.Assertions.*;
        assertEquals(expectedTitle, actualTitle);
    }
    // test method name: testYahooSearchResultPageTitle
    // test when you navigate to yahoo search page
        // and search for Selenium
            // Title should start with selenium
    @Test
    public void testYahooSearchResultPageTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://search.yahoo.com/");

        WebElement searchBox = driver.findElement(By.name("p"));
        // we can simulate key stroke using Keys.SELECT_ONE_OF_THE_OPTION
        // in this case we are typing selenium and hitting enter
        searchBox.sendKeys("Selenium" + Keys.ENTER);
        // driver.findElement(By.id("yschsp")).submit();

        // String expectedTitle = "selenium";
        String actualTitle = driver.getTitle();

        // quit browser
        driver.quit();

        // do static import, so you can do this
        // import static org.junit.jupiter.api.Assertions.*;
        assertTrue(actualTitle.startsWith("Selenium"));
    }
}
