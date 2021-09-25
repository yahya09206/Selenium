package com.cybertek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

// This isn't a test class so we can not extend testbase
// it simply doesn't make sense

// 3. Create new `WebOrderUtility` with different name or modify existing one.
//      1. remove `WebDriver driverParam`
//      2. re-create the methods to use `Driver.getDriver()`
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
    }

// 4. Update `isAtOrderPage()` for performance
//    1. observe : the code works great when header element found ,but forced to wait for 10 seconds of implicit wait when element not found
//    2. use Explicit wait technic we learned to minimize the wait time to 2 seconds max by waiting accoridng to expected condition of header element is visible : `visibilityOfElementLocated` condition
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
//    5. Create a method called openWebOrderApp()
//    - no param , no return type
//    - simply navigate to WebOrder login page
//    - use `Driver` class we created , no param!
    public static void openWebOrderApp(){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login" +
                ".aspx");
    }

//  6. Create a method `verifyUserName`
//     1. accept `String username` as parameter
//     2. The method check the welcome message right beside `logout`
//        link contains username or not. for example `Welcome , Tester` contains `Tester`
//     3. return `true` if it match username passed, false if not.
    public static boolean verifyUserName(String username){
        boolean result = false;
        WebElement welcomeMsg = Driver.getDriver().findElement(By.xpath("//div[@class='login_info']"));
        String expectedName = welcomeMsg.;
        if (welcomeMsg.getText().contains("Tester")){
           result = true;
        }else {
            result = false;
        }
        return result;
    }
}
