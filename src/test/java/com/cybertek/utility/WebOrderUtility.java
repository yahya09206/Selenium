package com.cybertek.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


    /**
     This isn't a test class so we can not extend testbase
     it simply doesn't make sense

     3. Create new `WebOrderUtility` with different name or modify existing one.
          1. remove `WebDriver driverParam`
          2. re-create the methods to use `Driver.getDriver()`
     */
public class WebOrderUtility{

    public static void login(){

        // BELOW LINE WILL NOT WORK BECASUE IT WILL OPEN NEW DRIVER EACH TIME
        // WebDriver driver = WebDriverFactory.getDriver("chrome");
        // enter username
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        // enter password
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        // click login
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    public static void login(String username, String password){

        // BELOW LINE WILL NOT WORK BECASUE IT WILL OPEN NEW DRIVER EACH TIME
        // WebDriver driver = WebDriverFactory.getDriver("chrome");
        // enter username
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        // enter password
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        // click login
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    public static void logout(){

        // logout link has id of ctl00_logout
        Driver.getDriver().findElement(By.id("ctl00_logout")).click();
        Driver.getDriver().quit();
    }

    /**
     4. Update `isAtOrderPage()` for performance
        1. observe : the code works great when header element found ,but forced to wait for 10 seconds of implicit wait when element not found
        2. use Explicit wait technic we learned to minimize the
        wait time to 2 seconds max by waiting accoridng
        to expected condition of header element is visible : `visibilityOfElementLocated` condition
     */
    public static boolean isAtOrderPage(){
        boolean result = false ;
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);
            wait.until(visibilityOfElementLocated(By.xpath("//h2[normalize-space(.)='List of All Orders']"))) ;
            System.out.println("ELEMENT WAS IDENTIFIED ");
            result = true ;
        }catch (TimeoutException e){
            System.out.println("NO Such element! you are not at the right page");
        }
        return result ;
    }

    /**
        5. Create a method called openWebOrderApp()
            - no param , no return type
            - simply navigate to WebOrder login page
            - use `Driver` class we created , no param!
     */
    public static void openWebOrderApp(){

        Driver.getDriver().get(
                "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login" +
                ".aspx");
    }

    /**
     * 6. Create a method `verifyUserName`
     *      1. accept `String username` as parameter
     *      2. The method check the welcome message right beside `logout`
     *         link contains username or not. for example `Welcome , Tester` contains `Tester`
     *      3. return `true` if it match username passed, false if not.
     *      */
    public static boolean verifyUserName(String username){
        boolean result;
        WebElement welcomeMsg = Driver.getDriver().findElement(By.xpath("//div[@class='login_info']"));
        if (welcomeMsg.getText().contains("Tester")){
            System.out.println("Correct username");
           result = true;
        }else {
            result = false;
        }
        return result;
    }

    /**
     * 7. Create a method `selectSideBarTab`
     *    1. accept `String tabName` no return type.
     *    2. click on the tab according to the tabName provided, for example :
     *    if "View all products" passed to the method , it should click on second tab. */
    public static void selectSideBarTab(String tabName){
        //Which web elements are available
        WebElement viewAllOrders = Driver.getDriver().findElement(By.xpath("//a[.='View all orders']"));
        WebElement viewAllProds = Driver.getDriver().findElement(By.xpath("//a[.='View all products']"));
        WebElement viewOrder = Driver.getDriver().findElement(By.xpath("//a[.='Order']"));

        if (tabName.equals("View all orders")){
            viewAllOrders.click();
        }else if(tabName.equals("View all products")){
            viewAllProds.click();
        }else if(tabName.equals("Order")){
            viewAllOrders.click();
        }else {
            System.out.println("No such tab available");
        }
    }

    /**8. Create a method `checkAll`
     1. accept no param , return `boolean`
     2. click on `Check All` button
     3. return `true` if all checkboxes are checked , false if any left unchecked
     * */
    public static boolean checkAll(){
        boolean result = false;
        // select check box and click
        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkBoxesClicked = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement webElement : checkBoxesClicked) {
            if (webElement.isSelected()){
                result = true;
            }else {
                result = false;
            }
        }
        return result;
    }

    /**
     * 9. Create a method `uncheckAll`
     *    1. accept no param , return `boolean`
     *    2. click on `Uncheck All` button
     *    3. return `true` if all checkboxes are unchecked , false if any left checked
     * */
    public static boolean unCheckAll(){
        boolean result = false;
        // select check box and click
        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        List<WebElement> checkBoxesUnlicked = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement webElement : checkBoxesUnlicked) {
            if (!webElement.isSelected()){
                result = true;
            }else {
                result = false;
            }
        }
        return result;
    }

    /**
     * 10. Create a method `getAllProducts`
     *     1.  accept no param ,
     *     2.  return `List<String>`
     *     3.  click on `View All Products` tab
     *     4.  save each cell value in first column `Product name` in the table into `List<String>`
     * */
    public static List<String> getAllProducts(){
        selectSideBarTab("View all products");
        //click on view all products tabs
//        WebElement viewAllProducts = Driver.getDriver().findElement(By.xpath("//a[.='View all products']"));
//        viewAllProducts.click();
        List<String> result = new ArrayList<>();
        List<WebElement> allProducts = Driver.getDriver().findElements(By.xpath("//div[@class = 'ProductsTable']"));
        for (WebElement allProduct : allProducts) {
            result.add(allProduct.getText());
        }
        return result;
    }

    /**
     * ## Homework 3 : method practice
     * 11. Create a method `getUnitPriceFromForm`
     *     1.  accept `String productName`
     *     2.  return `int` for unit price
     *     3.  It should
     *         1.  select product from product dropdown list
     *         2.  click `calculate` button
     *         3.  get the value attribute of `Price per unit:` input box
     *         4.  return it from the method. */
    public static int getUnitPriceFromForm(String productName){
        selectSideBarTab("Order");
        int result = 0;
        // select product from dropdown list
        Select select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue(productName);

        // get value attribute from unit price box
        WebElement unitPrice = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        result = Integer.parseInt(unitPrice.getAttribute("value"));

        return result;
    }

    /**
     * 12. Create a method `getDiscountFromForm`
     *     1.  accept `String productName` , `int quantity`
     *     2.  return `int` for discount
     *     3.  It should
     *         1.  select `productName` from product dropdown list
     *         2.  Enter `quantity` into `Quantity:*` inputbox (Fact : discount apply only
     *         if quantity is 10+)
     *         3. click `calculate` button
     *         4. get text attribute of `discount` inputbox and return from the method.
     * */
    public static int getDiscountFromForm(String productName, int quantity){
        selectSideBarTab("Order");
        int result = 0;
        Select select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue(productName);

        // enter quantity
        WebElement quantityBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBox.click();
        quantityBox.sendKeys("" + quantity);
        //click calculate button
        WebElement calculateBtn = Driver.getDriver().findElement(By.xpath("//input[@value='Calculate']"));
        calculateBtn.click();
        //locate discount box
        WebElement discountBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount"));
        // get value attribute from discount box and return
        String valueOfDiscount = discountBox.getAttribute("value");
        result = Integer.parseInt(valueOfDiscount);

        return result;
    }

    /**
     * 13. Create a method `calculateTotal`
     *     1.  accept `String productName` , `int quantity`
     *     2. return `int` for total
     *     3. It should
     *        1.  select `productName` from product dropdown list
     *        2.  Enter `quantity` into `Quantity:*` inputbox
     *        3.  Click `calculate` button
     *        4.  get text attribute of `Total` inputbox and return from the method.
     */
    public static int calculateTotal(String productName, int quantity){

        selectSideBarTab("Order");
        int result = 0;
        Select select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue(productName);
        WebElement quantityBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBox.click();
        quantityBox.sendKeys("" + quantity);
        //click calculate button
        WebElement calculateBtn = Driver.getDriver().findElement(By.xpath("//input[@value='Calculate']"));
        calculateBtn.click();
        // get text attribute of 'Total' input box
        WebElement totalBox = Driver.getDriver().findElement(By.id("name=\"ctl00$MainContent$fmwOrder$txtTotal\""));
        String valueOfTotal = totalBox.getAttribute("value");
        result = Integer.parseInt(valueOfTotal);

        return result;
    }

    /**
     * 13. Create a method `getExpectedDiscount`
     *     1.  accept `String productName` , `int quantity`
     *     2.  return `discount` amount according to `productName`,`quantity`
     *     3.  It should
     *         - if `quantity` is less than 10
     *           - return `0`
     *         - else according to all products table
     *           - return `correct discount number` : 8 , 15, 10*/
    public static double getExpectedDiscount(String productName, int quantity){
        int result = 0;
        selectSideBarTab("Order");

        Select select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue(productName);

        WebElement quantityBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBox.sendKeys(""+quantity);

        WebElement calculateButton = Driver.getDriver().findElement(By.xpath("//input[@value = 'Calculate']"));
        calculateButton.click();

        WebElement discountInbox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount"));
        String valueString = discountInbox.getAttribute("value");

        result = Integer.parseInt(valueString);
        System.out.println(result);
        return result;
    }

    /**
     * 14. Create a void method `enterAddressInfo`
     *     1.  accept no param (optionally you can parameterize it but we will use `javafaker` library to randomize it later)
     *     2.  It should fill up the `Address Information` section of order form
     */
    public static void enterAddressInfo(){
        selectSideBarTab("Order");
        // locate input boxes for address
        WebElement nameBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        // call faker class
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = faker.number().digits(5);

        // enter info into boxes
        nameBox.sendKeys(name);
        streetBox.sendKeys(street);
        cityBox.sendKeys(city);
        stateBox.sendKeys(state);
        zipBox.sendKeys(zipCode);
    }

    /**
     *15.  Create a void method `enterPaymentInfo`
     *     1.  accept no param (optionally you can parameterize it but we will use `javafaker` library to randomize it later)
     *     2.  It should fill up the `Payment Information` section of order form
     */
    public static void enterPaymentInfo(){
        selectSideBarTab("Order");

        // select which radio button
        List<WebElement> radioBtn = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));
        WebElement cardNumberBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        WebElement expDateBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));

        if (radioBtn.equals("Visa")){
            radioBtn.get(0).click();
        }else if (radioBtn.equals("MasterCard")){
            radioBtn.get(1).click();
        }else if (radioBtn.equals("American Express")){
            radioBtn.get(2).click();
        }

        // enter payment info
        Faker faker = new Faker();
        String cardNum = faker.number().digits(16);
        String date = "05/2025";

        cardNumberBox.sendKeys(cardNum);
        expDateBox.sendKeys(date);
    }

    /**
     *
     * 16. Create a void method `submitAndVerify`
     *     1. accept no param return boolean
     *     2. click on `process` button
     *     3. check if `New order has been successfully added.` message present
     *     4. return `true` if it is , false if it is not.
     *     5. Use explicit wait to avoid long wait time if not present.
     */
    public static boolean submitAndVerify(){
        selectSideBarTab("Order");
        boolean result = false;
        // select process button
        WebElement processBtn = Driver.getDriver().findElement(By.xpath("//div[@class='btn_light']"));
        processBtn.click();

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//strong"));
        String expectedMessage = "New order has been successfully added.";
        String actualMsg = successMessage.getText();

        // check if messages match
        if (expectedMessage.equals(actualMsg)){
            result = true;
        }else {
            result = false;
        }

        return result;

    }

}
