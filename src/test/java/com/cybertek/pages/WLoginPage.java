package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WLoginPage {

    @FindBy()
    public WebElement userNameField;
    public WebElement passwordField;
    public WebElement loginButton;
}
