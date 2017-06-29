package com.dfexamples.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.dfexamples.Framework.Enums.BrowserPaths.*;

public class DriverManager {

    public static WebDriver DriverInstance;
    public static String OperatingSystem = PropertyManager.getProperty("operating_system");
    public static String ChromeDriver = WEBDRIVER_CLIENT_PATH.getPath() + CHROME_DRIVER_PATH.getPath();
    public static String FirefoxDriver = WEBDRIVER_CLIENT_PATH.getPath() + GECKO_DRIVER_PATH.getPath();

    public static void Initialize() {
        String browsername = PropertyManager.getProperty("SelectedBrowser");

        if (browsername.isEmpty())
            browsername = System.getProperty("browserType");

        setUpDriverInstance(browsername);

        DriverInstance.manage().window().maximize();

        DriverInstance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private static void setUpDriverInstance(String browsername) {
        switch (browsername) {
            case "Chrome":
                setUpDriverInstanceUsingChrome();
                break;

            case "Firefox":
                setUpDriverInstanceUsingFirefox();
                break;

            case "Marionette":
                setUpDriverInstanceUsingMarionette();
                break;

            default:
                setUpDriverInstanceUsingChrome();
                break;
        }
    }

    private static void setUpDriverInstanceUsingChrome() {
        System.setProperty("webdriver.chrome.driver", checkOsForDriverExtension(ChromeDriver));
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        options.addArguments("window-size=1920,1080");
        options.addArguments("disable-infobars");
        DriverInstance = new ChromeDriver(options);
    }

    private static void setUpDriverInstanceUsingFirefox() {
        System.setProperty("webdriver.gecko.driver", checkOsForDriverExtension(FirefoxDriver));
        DriverInstance = new FirefoxDriver();
    }

    private static void setUpDriverInstanceUsingMarionette() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        System.setProperty("webdriver.gecko.driver", checkOsForDriverExtension(FirefoxDriver));
        DriverInstance = new FirefoxDriver(capabilities);
    }

    private static String checkOsForDriverExtension(String driverPath) {
        return (OperatingSystem.equalsIgnoreCase("mac os x") ? driverPath : driverPath + ".exe");
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
