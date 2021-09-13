package com.cybertek.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cybertekschool.com/forgot_password");

        // locate two elements using css selector
        // input[name='email']
        // form input[name='email]
        // form#forgot_password input input[name='email']
        // #forgot_password input[name='email']
        WebElement emailBox = driver.findElement(By.cssSelector("input[name='email']"));

    }
}
