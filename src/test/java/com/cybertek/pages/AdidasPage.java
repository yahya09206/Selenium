package com.cybertek.pages;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdidasPage {

    public AdidasPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement purchasePrice;

    //a[.='Add to cart']
    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addCart;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeLink;

    public void addProduct(String category){

        // Dynamic categories locator //a[.='"+category+"']
        // Dynamic products locator //a[normalize-space(.)='"+product+"']
        Driver.getDriver().findElement(By.xpath("//a[.='\"+category+\"']")).click();
        BrowserUtil.waitFor(1);

        Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='\"+product+\"']")).click();
        BrowserUtil.waitFor(1);

        String priceString = purchasePrice.getText();
        System.out.println("priceString = " + priceString);


    }
}
