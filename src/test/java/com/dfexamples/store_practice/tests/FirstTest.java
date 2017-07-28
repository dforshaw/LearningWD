package com.dfexamples.store_practice.tests;

import com.dfexamples.Framework.Utilities.CreateEmail;
import com.dfexamples.store_practice.Enums.TestURL;
import com.dfexamples.Framework.DriverManager;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest extends BaseTest {

    @Ignore
    @Test
    public void Initial_Navigation_Test() {
        DriverManager.DriverInstance.navigate().to(TestURL.BASE_ADDRESS.getUrl());
        assertThat(DriverManager.DriverInstance.getTitle()).isEqualToIgnoringCase("My Store");
    }

    @Ignore
    @Test
    public void Email_Creation_Test() {
        String email = "";

        email = CreateEmail.generate();

        System.out.println(email);
    }
}
