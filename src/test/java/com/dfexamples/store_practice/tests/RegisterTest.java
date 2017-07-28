package com.dfexamples.store_practice.tests;

import com.dfexamples.store_practice.Pages.AuthenticationPage;
import com.dfexamples.store_practice.Pages.CreateAccountPage;
import com.dfexamples.store_practice.Pages.HomePage;
import com.dfexamples.store_practice.Pages.MyAccountPage;
import com.dfexamples.testtheinternet.Enums.TestUser;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void User_Can_Register_A_New_Account() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        AuthenticationPage.createAccountWithEmail("");
        CreateAccountPage.enterUserAccountData();
    }

    @Test
    public void User_Can_Register_A_New_Account_And_Sign_Out() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        AuthenticationPage.createAccountWithEmail("");
        CreateAccountPage.enterUserAccountData();
        MyAccountPage.signOut();
    }

    @Test
    public void User_Can_Register_Sign_Out_And_Log_Back_In() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        AuthenticationPage.createAccountWithEmail("");
        String email = CreateAccountPage.getEmail();
        CreateAccountPage.enterUserAccountData();
        MyAccountPage.signOut();
        AuthenticationPage.loginWithEmail(email, TestUser.USER_W_BAD_PWD.getPassword());
    }
}
