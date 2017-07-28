package com.dfexamples.store_practice.tests;

import com.dfexamples.store_practice.Enums.TestUser;
import com.dfexamples.store_practice.Pages.AuthenticationPage;
import com.dfexamples.store_practice.Pages.HomePage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void User_Can_Login_To_Account() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        AuthenticationPage.loginWithEmail(TestUser.USER_W_GOOD_INFO.getUsername(), TestUser.USER_W_GOOD_INFO.getPassword());
    }
}
