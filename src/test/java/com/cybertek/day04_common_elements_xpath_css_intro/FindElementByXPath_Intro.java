package com.cybertek.day04_common_elements_xpath_css_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByXPath_Intro {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        // /html/body/div/div[2]/div/div/div/h1/span
        // XPath can be used to navigate through elements and attributes in an html document

        // Using above full XPath to identify the element and get the text
        WebElement headerSpan = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/h1/span"));
    }
}
