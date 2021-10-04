package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WCommonArea {

    @FindBy(id = "ctl00_logout")
    public WebElement logoutLink;

    @FindBy(id = "View all order")
    public WebElement viewAllOrderTab;

    @FindBy(id = "View all products")
    public WebElement viewAllProductTab;

    @FindBy(id = "Order")
    public WebElement orderTab;




}
