package com.cybertek.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework2 {
    public static void main(String[] args) throws InterruptedException {

        //Set up Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/");

        // get all the links that have partial text A in it
        List<WebElement> allLinks = driver.findElements(By.partialLinkText("A"));

        if (driver.getTitle().equals("Zero - Personal Banking - Loans - Credit Cards")){
            driver.findElement(By.id("signin_button")).click();
        }

        Thread.sleep(2000);
        if (driver.getTitle().equals("Zero - Log in")){
            WebElement signinBox = driver.findElement(By.id("user_login"));
            signinBox.sendKeys("username");
            WebElement passwordBox = driver.findElement(By.id("user_password"));
            passwordBox.sendKeys("password");
            Thread.sleep(2000);
            driver.findElement(By.name("submit")).click();
        }

        Thread.sleep(2000);
        if (driver.getTitle().equals("Zero - Account Summary")){
            // get the first item and get the text
            System.out.println("Success");
        }

        Thread.sleep(3000);

        driver.quit();


    }
}
