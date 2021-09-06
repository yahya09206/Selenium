package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextPartialLinkTextPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        // click on first link A/B testing
        //WebElement firstLink = driver.findElement(By.linkText("A/B Testing"));
        //firstLink.click();

        driver.findElement(By.linkText("A/B Testing")).click();

        // navigate back to homepage
        driver.navigate().back();

        // maximize the screen here
        driver.manage().window().maximize();

        // click on second link, either full linktext or partial link text
        driver.findElement(By.linkText("Add/Remove Elements")).click();


        // click on home link to go back to home

        // click on redirect link

        // close browser
        driver.close();
    }
}
