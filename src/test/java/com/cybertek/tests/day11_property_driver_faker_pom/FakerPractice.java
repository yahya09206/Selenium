package com.cybertek.tests.day11_property_driver_faker_pom;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class FakerPractice {

    @Test
    public void testPrintFakeData(){

        Faker faker = new Faker();

        // faker.YourCategory.WhateverAvailable();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        // fake book info
        System.out.println("faker.book().title() = " + faker.book().title());
    }
}
