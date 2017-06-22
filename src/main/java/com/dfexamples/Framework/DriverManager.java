package com.dfexamples.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.dfexamples.Framework.Enums.BrowserPaths.CHROME_DRIVER_PATH;
import static com.dfexamples.Framework.Enums.BrowserPaths.GECKO_DRIVER_PATH;
import static com.dfexamples.Framework.Enums.BrowserPaths.WEBDRIVER_CLIENTS;
import static com.dfexamples.Framework.Enums.CommonPaths.CODE_DIRECTORY_HOME;
import static com.dfexamples.Framework.Enums.CommonPaths.USER_HOME_DIRECTORY;

public class DriverManager {

    public static WebDriver DriverInstance;
    public static String OperatingSystem = PropertyManager.getProperty("operating_system");
    public static String UserHomeDir = USER_HOME_DIRECTORY.getPath();
    public static String CodeDirectory = CODE_DIRECTORY_HOME.getPath();
//    public static String CodeDirectory = CODE_DIRECTORY_WORK.getPath();
    public static String WdClientDirectory = CodeDirectory + WEBDRIVER_CLIENTS.getPath();
    public static String ChromeDriverDirectory = WdClientDirectory + CHROME_DRIVER_PATH.getPath();
    public static String FirefoxDriverDirectory = WdClientDirectory + GECKO_DRIVER_PATH.getPath();

    public static void Initialize() {
        String browsername = PropertyManager.getProperty("SelectedBrowser");

        if (browsername.isEmpty())
            browsername = System.getProperty("browserType");

        setUpDriverInstance(browsername);

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
        String path = UserHomeDir + ChromeDriverDirectory;
        path = determineExtensionForBrowserDriver(path);

        System.setProperty("webdriver.chrome.driver", path);
        DriverInstance = new ChromeDriver();
    }

    private static void setUpDriverInstanceUsingFirefox() {
        String path = UserHomeDir + FirefoxDriverDirectory;
        path = determineExtensionForBrowserDriver(path);

        System.setProperty("webdriver.gecko.driver", path);
        DriverInstance = new FirefoxDriver();
    }

    private static void setUpDriverInstanceUsingMarionette() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        String path = UserHomeDir + FirefoxDriverDirectory;
        path = determineExtensionForBrowserDriver(path);

        System.setProperty("webdriver.gecko.driver", path);
        DriverInstance = new FirefoxDriver(capabilities);
    }

    private static String determineExtensionForBrowserDriver(String driverPath) {
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
