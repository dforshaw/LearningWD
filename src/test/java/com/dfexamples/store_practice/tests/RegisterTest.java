package com.dfexamples.store_practice.tests;

import com.dfexamples.Framework.Utilities.Capture;
import com.dfexamples.Framework.Utilities.CreateEmail;
import com.dfexamples.store_practice.Pages.AuthenticationPage;
import com.dfexamples.store_practice.Pages.CreateAccountPage;
import com.dfexamples.store_practice.Pages.HomePage;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void User_Can_Register_A_New_Account() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        AuthenticationPage.createAccountWithEmail();
        CreateAccountPage.enterUserAccountData();
    }
}
