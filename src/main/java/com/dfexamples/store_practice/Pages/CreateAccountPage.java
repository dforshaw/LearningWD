package com.dfexamples.store_practice.Pages;

import com.dfexamples.Framework.DriverManager;
import org.openqa.selenium.By;

public class CreateAccountPage {

    private static By createAccountHeader = By.cssSelector(".page-heading");
    static By registerButton = By.id("submitAccount");

    public static Boolean isAt() {
        String header = DriverManager.DriverInstance.findElement(createAccountHeader).getText();

        if (header.equalsIgnoreCase("Create an Account")) {
            System.out.println("On the Create Account Page");
            return true;
        }
        else return false;
    }

    public static void enterUserAccountData() {
        enterPersonalInformation();
        enterAddress();
    }

    private static void enterPersonalInformation() {
    }

    private static void enterAddress() {
    }
}
