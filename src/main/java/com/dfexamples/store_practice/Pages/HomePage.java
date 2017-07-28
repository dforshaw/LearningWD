package com.dfexamples.store_practice.Pages;

import com.dfexamples.store_practice.Enums.TestURL;
import org.openqa.selenium.By;

import static com.dfexamples.Framework.Utilities.Common.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private static By signInLink = By.cssSelector(".login");

    public static void goTo() {
        String url = TestURL.BASE_ADDRESS.getUrl() + TestURL.HOME_PAGE.getUrl();
        navTo(url);

        assertThat(isAt()).isTrue();
    }

    public static Boolean isAt() {
        waitForVisible(signInLink, 10);

        String title = getTitle();
        if (title.equalsIgnoreCase("My Store")) {
//            System.out.println("On Home page");
            return true;
        }
        else return false;
    }

    public static void selectSignInLink() {
        click(signInLink);

        assertThat(AuthenticationPage.isAt().equals(true));
    }
}
