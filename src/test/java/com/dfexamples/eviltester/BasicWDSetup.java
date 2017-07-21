package com.dfexamples.eviltester;

import com.dfexamples.Framework.PropertyManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.dfexamples.Framework.Enums.BrowserPaths.GECKO_DRIVER_PATH;
import static com.dfexamples.Framework.Enums.BrowserPaths.WEBDRIVER_CLIENT_PATH;

public class BasicWDSetup implements Config {

    protected static WebDriver driver;

    @Before
    public void setUp() {
        String driverPath = WEBDRIVER_CLIENT_PATH.getPath();
        driverPath += GECKO_DRIVER_PATH.getPath();
        driverPath +=
                PropertyManager
                .getProperty("operating_system")
                .equalsIgnoreCase("mac os x") ? "" : ".exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
