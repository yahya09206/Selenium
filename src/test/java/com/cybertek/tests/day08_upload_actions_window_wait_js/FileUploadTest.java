package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest extends TestBase {

    @Test
    public void testUpload(){

        driver.get("http://practice.cybertekschool.com/upload");

        // locate the input field : By.id("file-upload)
        /**
         * By.id("file-upload)
         * By.xpath("//input[@id='file-upload']")
         * By.cssSelector("input[id=file-upload']") Handle #file-upload
         **/

        WebElement fileInputField = driver.findElement(By.id("file-upload"));
        // find the full path of your file in your computer and send key into above input field
        String filePath = "/Users/solodolo/Desktop/Screen Shot 2021-08-16 at 12.40.46 PM.png";
        // insert file into upload field
        fileInputField.sendKeys(filePath);
        // click submit
        driver.findElement( By.id("file-submit")).click();

        BrowserUtil.waitFor(2);
        // TODO: Optionally Assert "File Uploaded!" success message showed up
        // Success message page: //h3[.='File Uploaded!']
        WebElement successMsg = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        assertTrue(successMsg.isDisplayed());


        // Thread.sleep(2000); is needed sometimes, but we are forced to deal with check exception
        // objective: have a utility method human-readable
        // BrowserUtil.waitFor(2); ===>> no exception handling just wait for 2 seconds
        // Create a class called BrowserUtil under utility package
        // Create a static void method called waitFor accept int as second to wait
    }
}
