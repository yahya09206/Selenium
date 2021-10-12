package com.cybertek.Practice_9_29_2021.adidasTask;

import com.cybertek.pages.AdidasPage;
import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

public class Adidas extends TestBase {

    @Test
    public void adidas(){

        Driver.getDriver().get(ConfigReader.read("adidas"));

        AdidasPage adidasPage = new AdidasPage();

        int expectedPrice = 0;
        expectedPrice += adidasPage.addProduct("Laptops", "Sony vaio i5");
        System.out.println("expectedPrice = " + expectedPrice);

        //• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
        expectedPrice+=adidasPage.addProduct("Phones","Samsung galaxy s6");
        System.out.println("expectedPrice = " + expectedPrice);

        //• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
        expectedPrice+=adidasPage.addProduct("Monitors","Apple monitor 24");
        System.out.println("expectedPrice = " + expectedPrice);


        adidasPage.cart.click();
        expectedPrice -=adidasPage.removeProduct("Apple monitor 24");
        System.out.println("expectedPrice = " + expectedPrice);

        adidasPage.placeOrder.click();

        adidasPage.fillForm();

    }
}
