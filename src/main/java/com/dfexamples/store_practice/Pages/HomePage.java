package com.dfexamples.store_practice.Pages;

import com.dfexamples.Framework.DriverManager;
import com.dfexamples.store_practice.Enums.TestURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.dfexamples.Framework.DriverManager.waitForClickable;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private static By signInLink = By.cssSelector(".login");

    public static void goTo() {
        String url = TestURL.BASE_ADDRESS.getUrl() + TestURL.HOME_PAGE.getUrl();

        DriverManager.DriverInstance.navigate().to(url);
        waitForClickable(signInLink, 10);
        assertThat(isAt().equals(true));
    }

    public static Boolean isAt() {
        String title = DriverManager.DriverInstance.getTitle();

        if (title.equalsIgnoreCase("My Store")) {
            return true;
        }
        else return false;
    }

    public static void selectSignInLink() {
        DriverManager.DriverInstance.findElement(signInLink).click();
        assertThat(AuthenticationPage.isAt().equals(true));
    }
}
