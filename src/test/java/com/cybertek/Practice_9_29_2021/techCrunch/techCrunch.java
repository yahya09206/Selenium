package com.cybertek.Practice_9_29_2021.techCrunch;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class techCrunch extends TestBase {

    @Test
    public void testCrunch(){

        Driver.getDriver().get(ConfigReader.read("tech_crunch"));

        // find latest news using xpath
        List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));
        System.out.println("latestNews.size() = " + latestNews.size());

        //dynamic for author
        // article[@class='post-block post-block--image post-block--unread'][4]//a[contains(@aria-label,'Posts by')]

        //dynamic for img
        //article[@class='post-block post-block--image post-block--unread'][3]//img

        for (int i = 0; i < latestNews.size(); i++){
            String authorLocators = "";
        }


    }
}
