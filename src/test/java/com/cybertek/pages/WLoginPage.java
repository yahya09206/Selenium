package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WLoginPage {

    @FindBy(id = "ctl100_MainContent_username")
    public WebElement userNameField;

    @FindBy(name = "ctl100$MainContent$password")
    public WebElement passwordField;

    @FindBy(css = "#ctl100_MainContent_login_button")
    public WebElement loginButton;

    // Now we need instruct selenium to start looking for element
    // when this constructor is called

}
