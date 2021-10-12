package com.cybertek.pages;

import com.cybertek.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class AdidasPage {

    public AdidasPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
