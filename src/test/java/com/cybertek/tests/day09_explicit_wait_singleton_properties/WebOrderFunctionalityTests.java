package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.Driver;
import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebOrderFunctionalityTests {
    @BeforeEach
    public void setUpAndLogin(){
        WebOrderUtility.openWebOrderApp();
        WebOrderUtility.login();

    }

    @AfterEach
    public void quit(){
        WebOrderUtility.logout();

    }

    @Test
    public void testCheckAllButton(){

        assertTrue(WebOrderUtility.checkAll());
    }

    @Test
    public void testUncheckAllButton(){

        assertTrue(WebOrderUtility.unCheckAll());
    }

    @Test
    public void testAllProductNames(){
        WebOrderUtility.selectSideBarTab("View all products");
        // check if headers are matching
        String actualHeader = Driver.getDriver().findElement(By.xpath("//h2")).getText();
        String expectedHeader = "List of Products";
        assertEquals(actualHeader, expectedHeader);

//        // check if list of orders match
//        String[] expectedArray = {"MyMoney", "FamilyAlbum", "ScreenSaver"};
//        List<String> expectedList = Arrays.asList(expectedArray);
//
//        List<String> actualList = WebOrderUtility.getAllProducts();
//        assertEquals(actualList, expectedList);


    }

    @Test
    public void testProductInformationPrice(){
        assertEquals(WebOrderUtility.getUnitPriceFromForm("MyMoney"),100);
        assertEquals(WebOrderUtility.getUnitPriceFromForm("FamilyAlbum"),80);
        assertEquals(WebOrderUtility.getUnitPriceFromForm("ScreenSaver"),20);

    }

    @Test
    public void testProductInformationDiscount(){

        assertEquals(WebOrderUtility.getExpectedDiscount("MyMoney", 10), 8);
        assertEquals(WebOrderUtility.getExpectedDiscount("FamilyAlbum", 15), 15);
        assertEquals(WebOrderUtility.getExpectedDiscount("ScreenSaver", 20), 10);
    }

    @Test void testProductInformation_CalculationLessThan10(){
        assertEquals(WebOrderUtility.calculateTotal("MyMoney", 9), 9 * 100);
        assertEquals(WebOrderUtility.calculateTotal("FamilyAlbum", 9), 9 * 80);
        assertEquals(WebOrderUtility.calculateTotal("ScreenSaver", 9), 9 * 20);
    }

    @Test
    public void productInformation_Calculation10orGreater(){
        assertEquals(WebOrderUtility.calculateTotal("MyMoney", 10), 920);
        assertEquals(WebOrderUtility.calculateTotal("FamilyAlbum", 10), 680);
        assertEquals(WebOrderUtility.calculateTotal("ScreenSaver", 10), 180);
    }

    @Test
    public void testPaymentInfo(){
        WebOrderUtility.enterPaymentInfo();
    }

    @Test
    public void testOrderFlow(){
        WebOrderUtility.enterAddressInfo();
        BrowserUtil.waitFor(2);
        WebOrderUtility.enterPaymentInfo();
        BrowserUtil.waitFor(2);
        WebOrderUtility.submitAndVerify();
    }
}
