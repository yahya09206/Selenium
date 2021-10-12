package com.cybertek.Practice_9_29_2021.adidasTask;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

public class Adidas extends TestBase {

    @Test
    public void adidas(){

        Driver.getDriver().get(ConfigReader.read("adidas"));

        // Dynamic categories locator //a[.='"+category+"']
        // Dynamic products locator //a[normalize-space(.)='"+product+"']
    }
}
