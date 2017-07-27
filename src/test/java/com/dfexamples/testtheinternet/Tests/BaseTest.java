package com.dfexamples.testtheinternet.Tests;

import com.dfexamples.Framework.DriverManager;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() {
        DriverManager.initialize();
    }

    @After
    public void tearDown() {
        DriverManager.close();
        DriverManager.quit();
    }
}
