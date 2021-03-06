package com.dfexamples.testtheinternet.Pages;

import com.dfexamples.Framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.dfexamples.testtheinternet.Enums.TestURL.BASE_ADDRESS;
import static com.dfexamples.testtheinternet.Enums.TestURL.LOGIN_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage {

    private static By usernameSelector = By.id("username");
    private static By errorMsgSelector = By.cssSelector(".flash.error");;

    public static void goTo() {

        DriverManager.DriverInstance.navigate().to(BASE_ADDRESS.getUrl() + LOGIN_PAGE.getUrl());
        assertThat(DriverManager.DriverInstance.findElement(usernameSelector).isDisplayed());
    }

    public static LoginCommand loginAs(String userName) {

        return new LoginCommand(userName);
    }

    public static String getErrorMsg() {

        try {
            return DriverManager.DriverInstance.findElement(errorMsgSelector).getText();

        } catch (NoSuchElementException e) {
            return String.valueOf(e);
        }
    }
}
