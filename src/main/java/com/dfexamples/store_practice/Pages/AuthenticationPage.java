package com.dfexamples.store_practice.Pages;

import com.dfexamples.Framework.DriverManager;
import com.dfexamples.Framework.Utilities.CreateEmail;
import org.openqa.selenium.By;

import static com.dfexamples.Framework.Utilities.Common.click;
import static com.dfexamples.Framework.Utilities.Common.enterValue;
import static com.dfexamples.Framework.Utilities.Common.waitForClickable;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthenticationPage {

    private static By authenticationHeader = By.cssSelector(".page-heading");
    private static By emailToCreateAccountWith = By.id("email_create");
    private static By createAccountButton = By.id("SubmitCreate");
    private static By emailToLoginWith = By.id("email");
    private static By passwordToLoginWith = By.id("passwd");
    private static By loginAccountButton = By.id("SubmitLogin");

    public static Boolean isAt() {
        String header = DriverManager.DriverInstance.findElement(authenticationHeader).getText();

        if (header.equalsIgnoreCase("Authentication")) {

            waitForClickable(createAccountButton, 10);
            return true;
        }
        else return false;
    }

    public static void createAccountWithEmail(String em) {

        String email = em;

        if (email.isEmpty()) {
            email = CreateEmail.generate();
        }

        System.out.println(email);
        enterValue(emailToCreateAccountWith, email);
        click(createAccountButton);
        assertThat(CreateAccountPage.isAt().equals(true));
    }

    public static void loginWithEmail(String em, String pwd) {

        enterValue(emailToLoginWith, em);
        enterValue(passwordToLoginWith, pwd);
        click(loginAccountButton);
        assertThat(MyAccountPage.isAt().equals(true));
    }
}
