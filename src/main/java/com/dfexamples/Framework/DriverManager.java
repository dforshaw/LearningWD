package com.dfexamples.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.dfexamples.Framework.Enums.BrowserPaths.*;

public class DriverManager {

    public static WebDriver DriverInstance;

    public static void Initialize() {
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
//                options.addArguments("start-maximized");
                options.addArguments("window-size=1920,1080");
                options.addArguments("disable-infobars");
                return new ChromeDriver(options);

            case "Firefox":
                path += GECKO_DRIVER_PATH.getPath() + getDriverFileExtension();
                System.setProperty("webdriver.gecko.driver", path);
                return new FirefoxDriver();

            case "Marionette":
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);

                path += GECKO_DRIVER_PATH.getPath() + getDriverFileExtension();
                System.setProperty("webdriver.gecko.driver", path);
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

    public static void Close() {
        DriverInstance.close();
    }

    public static void Quit() {
        DriverInstance.quit();
    }

    public static void waitForClickable(By locator, int timeUnit) {
        WebDriverWait wait = new WebDriverWait(DriverManager.DriverInstance,timeUnit);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForVisible(By locator, int timeUnit) {
        WebDriverWait wait = new WebDriverWait(DriverManager.DriverInstance,timeUnit);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

