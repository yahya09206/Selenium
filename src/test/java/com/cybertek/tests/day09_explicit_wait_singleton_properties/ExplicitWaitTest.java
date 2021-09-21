package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ExplicitWaitTest extends TestBase {

    @Test
    public void testWaitForTitle(){

        //1. navigate to http://practice.cybertekschool.com/dynamic_loading
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //2. click on example 7
        driver.findElement(By.partialLinkText("Example 7")).click();
        //3. The title will show loading... until certain time,
        // we want to wait until the title value becomes "Dynamic Title"
        // this is how we create WebDriverWait object with driver and max time to wait
        WebDriverWait wait = new WebDriverWait(driver, 6);
        // then we use until method that accepts expected conditions
        // ExpectedConditions helper class has a lot of pre-written conditions
        // for common scenarios, so we don't have to build our own
        // in this case we are checking for title equal Dynamic Title
        //wait.until(ExpectedConditions.titleIs("Dynamic title"));

        // try different condition as below
        // wait until the spongebob image visible on screen
        // visibilityOfElementLocated accept locator as parameter
        // so this means wait 6 second max until the element located by tagName("img")
        // is visible on the screen
        // we did static import as below so our code can be shorter
        wait.until(visibilityOfElementLocated(By.xpath("//img[@alt='square pants']")));

        System.out.println("END");
    }

    @Test
    public void testByTextToBe(){

        //1. navigate to http://practice.cybertekschool.com/dynamic_loading
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //2. click on example 7
        driver.findElement(By.partialLinkText("Example 7")).click();

        WebElement alertArea = driver.findElement(By.id("alert"));
        System.out.println("alertArea.getText() = " + alertArea.getText());

        WebDriverWait wait = new WebDriverWait(driver, 6);
        // wait for the image show up
        wait.until(visibilityOfElementLocated(By.xpath("//img[@alt='square pants']")));
        // here we had to re-locate the element because
        // the attributes have changed,
        // element is not in the dom anymore error
        alertArea = driver.findElement(By.id("alert"));

        // the warning area initially has text of this page is slow wait for 5 seconds
        // after it load the text of that area become Done!
        // This is one of the ExpectedConditions we can use for waiting
    }
}
