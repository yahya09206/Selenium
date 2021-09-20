package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionClassTest extends TestBase {

    @Test
    public void testHoverAction(){
        /**
         * get first image
         * (//div[@class='example']/div/img)[1]
         * */
        driver.get("http://practice.cybertekschool.com/hovers");

        // locate first image and hover over to the image and verify user profile 1 displayed
        WebElement img1Elm = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));

        // Create instance of Action class by passing driver object
        Actions actions = new Actions(driver);
        actions.moveToElement(img1Elm).perform();

        BrowserUtil.waitFor(3);

        // and verify User Profile 1 is displayed with text "name: user1"
        WebElement firstProfileElm = driver.findElement(By.xpath("//h5[.='name: user1']"));
        assertTrue(firstProfileElm.isDisplayed());

        // locate second image and hover over to the image and verify user profile 1 displayed
        WebElement img2Elm = driver.findElement(By.xpath("(//div[@class='figure']/img)[2]"));
        actions.moveToElement(img2Elm).perform();

        BrowserUtil.waitFor(3);

        // perform these actions in this sequence
        // hover over to 1st image, pause 2 seconds, then second image pause for 2 second
        // then hover over to 1st image again, pause 2 seconds then second image pause 2 seconds
        // PERFORM THE ACTION!!!
        actions.moveToElement(img1Elm).pause(2000)
                .moveToElement(img2Elm).pause(2000)
                .moveToElement(img1Elm).pause(2000)
                .moveToElement(img2Elm).pause(2000)
                .perform();


        //TODO: Homework: get a List<WebElement> containing those 3 images, Iterate over the list to hover over and
        // verify the text

    }

    @Test
    public void testDragAndDrop(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtil.waitFor(2);

        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement biggerCircle = driver.findElement(By.id("droptarget"));

        // dragAndDrop method of Actions class, accept 2 webelement and drop first one into second one
        Actions actions = new Actions(driver);
        actions.dragAndDrop(smallCircle, biggerCircle).perform();

        BrowserUtil.waitFor(2);

        // verify the big circle test has change to You did great!
        assertEquals("You did great!", biggerCircle.getText());
    }

    @Test
    public void testKeyboardAction(){

        // navigate to https://www.google.com
        // hold down to shift enter text "i love selenium"
        // release the shift
        // enter text "i love selenium"
        // hold down to command on mac and enter "A"
        // release the command or control key
        // then hit backspace to delete
        driver.get("https://www.google.com");
        // locate searchBox using name value q
        WebElement searchBox = driver.findElement(By.name("q"));
        // create actions class instance
        Actions actions = new Actions(driver);
        // keyDown method for holding down to certain modifier key like Control, Shift and so on
        // keyUp method is for releasing what you are holding down
        // sendKeys method of Actions class is for pressing keys that are provided
        // pause method of Actions class is for pausing in between actions in milliseconds
        actions.keyDown(Keys.SHIFT).sendKeys("i love selenium")
                .pause(2000).keyUp(Keys.SHIFT)
                .sendKeys("i love selenium").pause(2000)
                .keyDown(Keys.COMMAND).sendKeys("A")// will select all text on mac
                .keyUp(Keys.COMMAND).pause(2000)
                .sendKeys(Keys.BACK_SPACE)
                .perform();

    }
}
