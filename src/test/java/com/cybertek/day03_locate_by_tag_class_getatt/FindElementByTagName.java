package com.cybertek.day03_locate_by_tag_class_getatt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByTagName {
    public static void main(String[] args) {

        /*
         * Purple tag name
         * Orange attribute name
         * blue attribute value
         * black it is the text
         * */

        // set up driver and open chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // identify first element with tag name a
        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("firstLink.getText() = " + firstLink.getText());

        // close browser
        driver.quit();

    }
}
