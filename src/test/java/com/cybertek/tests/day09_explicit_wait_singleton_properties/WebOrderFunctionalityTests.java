package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
