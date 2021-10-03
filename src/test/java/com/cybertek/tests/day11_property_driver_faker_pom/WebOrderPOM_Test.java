package com.cybertek.tests.day11_property_driver_faker_pom;

import com.cybertek.pages.WLoginPage;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

public class WebOrderPOM_Test extends TestBase {

    @Test
    public void testWithPOM_for_login(){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/login.aspx");
        WLoginPage loginPage = new WLoginPage();
    }
}
