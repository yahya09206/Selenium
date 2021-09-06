package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindMultipleElements {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        // get all the links that have partial text A in it
        List<WebElement> allLink = driver.findElements(By.partialLinkText("A"));

        // get the size of this list so we know how many links with partial text A
        System.out.println("allLink.size() = " + allLink.size());

        driver.quit();

    }
}
