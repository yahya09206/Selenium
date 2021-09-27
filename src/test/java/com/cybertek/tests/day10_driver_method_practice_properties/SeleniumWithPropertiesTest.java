package com.cybertek.tests.day10_driver_method_practice_properties;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

public class SeleniumWithPropertiesTest extends TestBase {

    @Test
    public void testWebOrderLogin(){

        // use ConfigReader everywhere
        System.out.println("ConfigReader.read(\"weborder_url\") = " + ConfigReader.read("weborder_url"));
        System.out.println("ConfigReader.read(\"weborder_username\") = " + ConfigReader.read("weborder_username"));
        System.out.println("ConfigReader.read(\"weborder_password\") = " + ConfigReader.read("weborder_password"));



    }

}
