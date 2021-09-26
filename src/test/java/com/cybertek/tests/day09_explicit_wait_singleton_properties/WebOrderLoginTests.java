package com.cybertek.tests.day09_explicit_wait_singleton_properties;

import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.Test;

public class WebOrderLoginTests {

    @Test
    public void testLoginWithCorrectCredentials(){

        WebOrderUtility.openWebOrderApp();
    }

}
