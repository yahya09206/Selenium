package com.cybertek.Practice_9_29_2021.techCrunch;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

public class techCrunch extends TestBase {

    @Test
    public void testCrunch(){

        Driver.getDriver().get(ConfigReader.read("tech_crunch"));
    }
}
