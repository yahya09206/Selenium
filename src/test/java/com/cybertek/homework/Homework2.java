package com.cybertek.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {
    public static void main(String[] args) throws InterruptedException {

        //Set up Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/");

        if (driver.getTitle().equals("Zero - Personal Banking - Loans - Credit Cards")){
            driver.findElement(By.id("signin_button")).click();
        }

        Thread.sleep(2000);
        if (driver.getTitle().equals("Zero - Log in")){
            WebElement signinBox = driver.findElement(By.id("user_login"));
            signinBox.sendKeys("username");
            WebElement passwordBox = driver.findElement(By.id("user_password"));
            passwordBox.sendKeys("password");
        }
    }
}
