package com.dfexamples.store_practice.tests;

import com.dfexamples.framework.DriverManager;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() {
        DriverManager.Initialize();
    }

    @After
    public void tearDown() {
        DriverManager.Close();
        DriverManager.Quit();
    }
}
