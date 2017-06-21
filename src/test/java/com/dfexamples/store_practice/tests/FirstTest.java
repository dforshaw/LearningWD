package com.dfexamples.store_practice.tests;

import com.dfexamples.store_practice.Enums.TestURL;
import com.dfexamples.framework.DriverManager;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest extends BaseTest {

    @Test
    public void Initial_Navigation_Test() {
        DriverManager.DriverInstance.navigate().to(TestURL.BASE_ADDRESS.getUrl());
        assertThat(DriverManager.DriverInstance.getTitle()).isEqualToIgnoringCase("My Store");
    }
}
