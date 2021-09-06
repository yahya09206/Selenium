package com.cybertek.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        // identify username and password boxes
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("invalid username");

        // password
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("some password");

        // click login button
        WebElement login = driver.findElement(By.name("login"));
        login.submit();

        // navigate back to login screen
        driver.navigate().back();

        // pause
        Thread.sleep(5000);

        // click on forgot password link
        WebElement forgot = driver.findElement(By.linkText("Forgot Password?"));
        forgot.click();

        Thread.sleep(5000);

        // not me button
        WebElement notMe = driver.findElement(By.name("reset_action"));
        notMe.click();

        Thread.sleep(5000);

        // enter mobile number textbox
        WebElement phoneNumber = driver.findElement(By.id("identify_email"));
        phoneNumber.sendKeys("something");

        Thread.sleep(5000);

        // click on search button
        WebElement search = driver.findElement(By.id("did_submit"));
        search.click();

        Thread.sleep(5000);

        // click on cancel button
        WebElement cancel = driver.findElement(By.linkText("Cancel"));
        cancel.click();

        // close window
        driver.quit();

    }
}
