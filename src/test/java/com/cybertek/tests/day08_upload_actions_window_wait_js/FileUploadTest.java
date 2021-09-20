package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    }
}
