package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByName {
    public static void main(String[] args) {

        // set up chrome driver using web driver manager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //navigate to yahoo.com
        driver.get("https://yahoo.com");

        // identify yahoo search box by it's name attribute
        WebElement searchBox = driver.findElement(By.name("p"));
        searchBox.sendKeys("Selenium");

        // locate and click on button
        WebElement searchBtn = driver.findElement(By.id("ybar-search"));
        // any button can be clicked
        // only the buttons to submit the form can use submit method
        searchBtn.submit();

        // close browser
        driver.quit();
    }
}
