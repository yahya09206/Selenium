package com.cybertek.tests.day10_driver_method_practice_properties;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReadTest {

    @Test
    public void testInitialRead() throws IOException {

        // Open a connection to the file using FileInputStream object
        FileInputStream in = new FileInputStream("config.properties");

        // Create empty properties object
        Properties myProperty = new Properties();
        // Load the FileInputStream into the properties object
        myProperty.load(in);
        // close the connection by calling close method FileInputStream object
        in.close();

        // now actually read from the properties file using it's key
        String helloValue = myProperty.getProperty("hello");
        System.out.println("helloValue = " + helloValue);

        // read the value of key from "message"
        System.out.println("myProperty.getProperty(\"message\") = " + myProperty.getProperty("message"));

        System.out.println("myProperty.getProperty(\"weborder_url\") = " + myProperty.getProperty("weborder_url"));

    }

    @Test
    public void testReadWithTryCatch(){

        try {
            FileInputStream in = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
