package com.dfexamples.store_practice.Pages;

import com.dfexamples.Framework.DriverManager;
import org.openqa.selenium.By;

import static com.dfexamples.Framework.DriverManager.*;

public class CreateAccountPage {
/*
*   TO DO:
*   Implement optional fields
*   Convert locators to factory WebElements
*   Genericize State Dropdown locator
*/

    private static By createAccountHeader = By.cssSelector(".page-heading");
    private static By customerTitle = By.name("id_gender");
    private static By customerFirstName = By.id("customer_firstname");
    private static By customerLastName = By.id("customer_lastname");
    private static By customerPassword = By.id("passwd");
    private static By customerDobDay = By.id("days");
    private static By customerDobMonth = By.id("months");
    private static By customerDobYear = By.id("years");
    private static By addressFirstName = By.id("firstname");
    private static By addressLastName = By.id("lastname");
    private static By addressLine1 = By.id("address1");
    private static By addressCity = By.id("city");
    private static By addressState = By.cssSelector("#id_state>option[value='5']");
    private static By addressZip = By.id("postcode");
    private static By addressMobilePhone = By.id("phone_mobile");
    private static By addressAlias = By.id("alias");
    private static By registerButton = By.id("submitAccount");

    public static Boolean isAt() {
        String header = DriverManager.DriverInstance.findElement(createAccountHeader).getText();

        if (header.equalsIgnoreCase("Create an Account")) {

            waitForClickable(registerButton, 10);
            return true;
        }
        else return false;
    }

    public static void enterUserAccountData() {
        enterPersonalInformation();
        enterAddress();
        click(registerButton);
    }

    private static void enterPersonalInformation() {
        enterValue(customerFirstName, "Otto");
        enterValue(customerLastName, "Mashin");
        enterValue(customerPassword, "tester1");
   }

    private static void enterAddress() {
        enterValue(addressFirstName,"Otto");
        enterValue(addressLastName,"Mashin");
        enterValue(addressLine1,"100 Main Street");
        enterValue(addressCity,"Mountain View");
        DriverManager.DriverInstance.findElement(addressState).click();
        enterValue(addressZip,"94401");
        enterValue(addressMobilePhone,"5105551212");
        enterValue(addressAlias,"My Address");
    }
}
