package com.cybertek.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // locate two elements using xpath
        WebElement forgetPasswordHeader = driver.findElement(By.xpath("//h2[ text() = 'Forgot Password']"));
        System.out.println("forgetPasswordHeader.getText() = " + forgetPasswordHeader.getText());

        WebElement emailBox = driver.findElement(By.xpath("//input[ @name='email' and @type='text']"));
        emailBox.sendKeys("someone@somewhere.com");

        WebElement retrieveBtn = driver.findElement(By.xpath("//button[@id='form_submit' and @class='radius']"));
        retrieveBtn.click();

        // use xpath to identify confimation message
        WebElement confirmationMsg = driver.findElement(By.xpath("h4[@name='confirmation_message']"));
        System.out.println("confirmationMsg.getText() = " + confirmationMsg.getText());

    }
}
