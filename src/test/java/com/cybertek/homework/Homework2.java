package com.cybertek.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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


        Thread.sleep(5000);
        //driver.quit();

    }
}
