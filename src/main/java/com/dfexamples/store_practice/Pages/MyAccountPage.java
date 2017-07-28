package com.dfexamples.store_practice.Pages;

import com.dfexamples.Framework.DriverManager;
import org.openqa.selenium.By;

import static com.dfexamples.Framework.Utilities.Common.click;
import static com.dfexamples.Framework.Utilities.Common.waitForVisible;
import static org.assertj.core.api.Assertions.assertThat;

public class MyAccountPage {

    private static By myAccountHeader = By.cssSelector(".page-heading");
    private static By myPersonalInfoButton = By.cssSelector(".icon-user");
    private static By signOutButton = By.cssSelector(".logout");

    public static Boolean isAt() {

        waitForVisible(myPersonalInfoButton, 10);

        String header = DriverManager.DriverInstance.findElement(myAccountHeader).getText();
        if (header.equalsIgnoreCase("My Account")) {
//            System.out.println("On My Account page");
            return true;
        }
        else return false;
    }
    
    public static void signOut() {
        click(signOutButton);
        assertThat(AuthenticationPage.isAt()).isTrue();
    }
}
