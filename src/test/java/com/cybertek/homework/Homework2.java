package com.cybertek.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework2 {
    public static void main(String[] args) throws InterruptedException {

        // Set up Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com");

        // Search for Selenium
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        driver.findElement(By.name("btnI")).submit();

        // Get text from div that has count of results
        WebElement countDiv = driver.findElement(By.id("result-stats"));
        System.out.println("countDiv.getText() = " + countDiv.getText());

        // Get links that contain selenium
        List<WebElement> containSel = driver.findElements(By.partialLinkText("Selenium"));
        // Print size
        System.out.println("containSel.size() = " + containSel.size());
        // Print first
        WebElement firstElement = containSel.get(0);
        System.out.println("firstElement.getText() = " + firstElement.getText());
        // Print last
        WebElement lastElement = containSel.get(containSel.size()-1);
        System.out.println("lastElement.getText() = " + lastElement.getText());

        for (WebElement eachElement : containSel) {

            System.out.println("eachElement.getText() = " + eachElement.getText());
        }

        driver.quit();

    }
}
