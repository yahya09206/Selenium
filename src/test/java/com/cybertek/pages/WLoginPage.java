package com.cybertek.pages;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage {

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userNameField;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordField;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Invalid Login or Password.']")
    public WebElement errorBox;

    // Now we need instruct selenium to start looking for element
    // when this constructor is called
    public WLoginPage(){
        // PageFactory is a selenium class that supports POM, and it has a method initElements
        // once it's called, it will locate all the elements
        // specified using @FindBy annotation with locator
        // initElements accept 2 arguments
        // WebDriver instance and Page class instance (this) means current instance of this class
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Create a method goTo
     * accept no param just navigate to login page
     * use config.properties for url
     * */
    public void goTo(){

        Driver.getDriver().navigate().to(ConfigReader.read("weborder_url"));
    }

    /**
     * Login with parameters
     * @param username username
     * @param password password
     * */
    public void login(String username, String password){

        // you can access directly using userNameField or password
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();

    }

    /**
     * Check error message is present if wrong credentials are provided
     * loginErrorMsg present simple return the result of isDisplayed method call
     */
    public boolean loginErrorMsgPresent(){

        return this.errorBox.isDisplayed();
    }

}
