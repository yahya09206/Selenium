package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        // identify search box using both name and id
        WebElement searchBox = driver.findElement(By.name("q"));
                searchBox.sendKeys("Everything is awesome");
        // submit the search by clicking on the search button
        WebElement searchBtn = driver.findElement(By.name("btnK"));
                    searchBtn.submit();
        // navigate back to google home page
        driver.navigate().back();
        // wait a few seconds
        Thread.sleep(3000);

        // click on about link
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        aboutLink.click();
        // wait a few seconds
        Thread.sleep(3000);
        // close browser
        driver.quit();

    }
}
