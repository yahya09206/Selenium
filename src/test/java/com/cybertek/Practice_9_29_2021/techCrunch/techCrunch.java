package com.cybertek.Practice_9_29_2021.techCrunch;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Assertions;
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

        for (int i = 1; i <= latestNews.size(); i++){
            String authorLocator = "// article[@class='post-block post-block--image post-block--unread']["+i+"]//a[contains(@aria-label,'Posts by')]";
            WebElement author = Driver.getDriver().findElement(By.xpath(authorLocator));
            Assertions.assertTrue(author.isDisplayed());

            String imgLocator = "//article[@class='post-block post-block--image post-block--unread']["+i+"]//img";
            WebElement image = Driver.getDriver().findElement(By.xpath(imgLocator));
            Assertions.assertTrue(image.isDisplayed());
        }

        //3- Click one of the news from "The Latest News " list to reach the full content
//        - Verify the browser title is the same with the news title
        //- Verify the links within the news content
        latestNews.get(2).click();
        String expectedTitle = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        System.out.println("expectedTitle = " + expectedTitle);
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);

        Assertions.assertTrue(actualTitle.contains(expectedTitle));

        // Verify the links within the news content
        List<WebElement> allLinksFromArticle = Driver.getDriver().findElements(By.xpath("//div[@class='article-content']//a"));
        Assertions.assertTrue(allLinksFromArticle.size() > 0);

    }
}
