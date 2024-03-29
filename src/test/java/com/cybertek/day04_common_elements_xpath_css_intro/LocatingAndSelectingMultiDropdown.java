package com.cybertek.day04_common_elements_xpath_css_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatingAndSelectingMultiDropdown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        // TODO: Identify language multi select dropdown
        WebElement langDropdownElement = driver.findElement(By.name("Languages"));
        // TODO: Wrap it using Select class so we can use easy methods
        Select langSelectObj = new Select(langDropdownElement);
        // TODO: Call all available methods

        System.out.println("langSelectObj.isMultiple() = " + langSelectObj.isMultiple());

        langSelectObj.selectByIndex(2);
        langSelectObj.selectByValue("c");
        langSelectObj.selectByVisibleText("Java");
        // At this moment 3 options are select at same time

        // TODO: Deselect items
        langSelectObj.deselectByIndex(2);
        langSelectObj.deselectByValue("c");
        langSelectObj.deselectByVisibleText("Java");

    }
}
