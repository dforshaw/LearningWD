package com.dfexamples.store_practice.tests;

import com.dfexamples.Framework.DriverManager;
import com.dfexamples.Framework.Reports.JUnitHTMLReporter;
import org.junit.After;
import org.junit.Before;

public class BaseTest extends JUnitHTMLReporter {

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
