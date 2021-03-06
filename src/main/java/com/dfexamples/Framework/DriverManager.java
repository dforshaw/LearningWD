package com.dfexamples.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.dfexamples.Framework.Enums.BrowserPaths.*;

public class DriverManager {

    public static WebDriver DriverInstance;

    public static void initialize() {
        DriverInstance = createWebDriver();
        DriverInstance.manage().window().maximize();
        DriverInstance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private static WebDriver createWebDriver() {
        String browser = getBrowserName();
        String path = WEBDRIVER_CLIENT_PATH.getPath();

        switch (browser) {
            case "Chrome":
                path += CHROME_DRIVER_PATH.getPath() + getDriverFileExtension();
                System.setProperty("webdriver.chrome.driver", path);

                ChromeOptions options = new ChromeOptions();
                options.addArguments("window-size=1920,1080");
                options.addArguments("disable-infobars");

                return new ChromeDriver(options);

            case "Firefox":
                path += GECKO_DRIVER_PATH.getPath() + getDriverFileExtension();
                System.setProperty("webdriver.gecko.driver", path);

                return new FirefoxDriver();

            case "Marionette":
                path += GECKO_DRIVER_PATH.getPath() + getDriverFileExtension();
                System.setProperty("webdriver.gecko.driver", path);

                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);

                return new FirefoxDriver(capabilities);

            default:
                throw new RuntimeException("Unsupported webdriver: " + browser);
        }
    }

    private static String getBrowserName() {
        String browserName = PropertyManager.getProperty("SelectedBrowser");

        if (browserName.isEmpty())
            browserName = Optional.ofNullable(System.getProperty("browserType")).orElse("Chrome");

        return browserName;
    }

    private static String getDriverFileExtension() {
        String OperatingSystem = PropertyManager.getProperty("operating_system");
        return (OperatingSystem.equalsIgnoreCase("mac os x") ? "" : ".exe");
    }

    public static void close() {
        DriverInstance.close();
    }

    public static void quit() {
        DriverInstance.quit();
    }
}

