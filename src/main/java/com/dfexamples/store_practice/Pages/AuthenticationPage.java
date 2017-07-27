package com.dfexamples.store_practice.Pages;

import com.dfexamples.Framework.DriverManager;
import com.dfexamples.Framework.Utilities.CreateEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthenticationPage {

    private static By authenticationHeader = By.cssSelector(".page-heading");
    private static By emailCreateAccount = By.id("email_create");
    static By createAccountButton = By.id("SubmitCreate");

    public static Boolean isAt() {
        String header = DriverManager.DriverInstance.findElement(authenticationHeader).getText();

        if (header.equalsIgnoreCase("Authentication")) {
            System.out.println("On the Authentication Page");
            return true;
        }
        else return false;
    }

    public static void createAccountWithEmail() {

        String email = "";

        if (email.isEmpty()) {
            email = CreateEmail.generate();
        }

        System.out.println(email);

        DriverManager.DriverInstance.findElement(emailCreateAccount).sendKeys(email);
        DriverManager.DriverInstance.findElement(createAccountButton).click();

        WebDriverWait wait = new WebDriverWait(DriverManager.DriverInstance, 10);
        wait.until(ExpectedConditions.elementToBeClickable(CreateAccountPage.registerButton));

        assertThat(CreateAccountPage.isAt().equals(true));
    }
}
