package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {

        // set up chrome driver using web driver manager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //navigate to yahoo.com
        driver.get("https://yahoo.com");

        // locate search box and enter selenium
        WebElement searchBox = driver.findElement(By.id("ybar-sbq"));

        // enter text inside input box element using sendkey("your text")
        searchBox.sendKeys("Selenium");
        // locate the search button and click submit
        WebElement searchBtn = driver.findElement(By.id("ybar-search"));
        //searchBtn.click();
        searchBtn.submit();

        Thread.sleep(5000);

        // quit browser
        driver.quit();


    }
}
