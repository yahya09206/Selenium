package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.Driver;
import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.Test;

public class WebOrderTest {

    @Test
    public void testLogin(){

        // using new driver from Driver class
        Driver.openWebOrderApp();

        WebOrderUtility.login("Tester", "test");
        BrowserUtil.waitFor(2);

        WebOrderUtility.logout();

        BrowserUtil.waitFor(4);

    }
}
