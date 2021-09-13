package com.cybertek.tests.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.get("");
    }
    // test method name: testYahooSearchResultPageTitle
    // test when you navigate to yahoo search page
        // and search for Selenium
            // Title should start with selenium


}
