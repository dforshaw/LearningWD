package com.dfexamples.store_practice.Pages;

import com.dfexamples.Framework.DriverManager;
import com.dfexamples.store_practice.Enums.TestURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private static By signInLink = By.cssSelector(".login");

    public static void goTo() {
        DriverManager.DriverInstance.navigate().to(TestURL.BASE_ADDRESS.getUrl() + TestURL.HOME_PAGE.getUrl());

        WebDriverWait wait = new WebDriverWait(DriverManager.DriverInstance, 10);
        wait.until(ExpectedConditions.elementToBeClickable(signInLink));

        assertThat(isAt().equals(true));
    }

    public static Boolean isAt() {
        String title = DriverManager.DriverInstance.getTitle();

        if (title.equalsIgnoreCase("My Store")) {
            System.out.println("On the Home Page");
            return true;
        }
        else return false;
    }

    public static void selectSignInLink() {
        DriverManager.DriverInstance.findElement(signInLink).click();

        WebDriverWait wait = new WebDriverWait(DriverManager.DriverInstance, 10);
        wait.until(ExpectedConditions.elementToBeClickable(AuthenticationPage.createAccountButton));

        assertThat(AuthenticationPage.isAt().equals(true));
    }
}
