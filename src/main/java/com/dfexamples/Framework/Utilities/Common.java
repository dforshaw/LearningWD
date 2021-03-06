package com.dfexamples.Framework.Utilities;

import com.dfexamples.Framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common extends DriverManager {

    public static void waitForClickable(By locator, int timeUnit) {
        WebDriverWait wait = new WebDriverWait(DriverManager.DriverInstance,timeUnit);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForVisible(By locator, int timeUnit) {
        WebDriverWait wait = new WebDriverWait(DriverManager.DriverInstance,timeUnit);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void enterValue(By locator, String value) {
        DriverManager.DriverInstance.findElement(locator).clear();
        DriverManager.DriverInstance.findElement(locator).sendKeys(value);
    }

    public static void click(By locator) {
        DriverManager.DriverInstance.findElement(locator).click();
    }

    public static String getText(By locator) {
        return DriverManager.DriverInstance.findElement(locator).getText();
    }

    public static void navTo(String url) {
        DriverManager.DriverInstance.navigate().to(url);
    }

    public static String getTitle() {
        return DriverManager.DriverInstance.getTitle();
    }

    public static String getErrorMsg(By locator) {

        try {
            return getText(locator);
        } catch (NoSuchElementException e) {
            return String.valueOf(e);
        }
    }
}
