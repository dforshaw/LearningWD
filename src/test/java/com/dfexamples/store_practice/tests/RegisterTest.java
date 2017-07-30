package com.dfexamples.store_practice.tests;

import com.dfexamples.store_practice.Pages.AuthenticationPage;
import com.dfexamples.store_practice.Pages.RegisterNewUserPage;
import com.dfexamples.store_practice.Pages.HomePage;
import com.dfexamples.store_practice.Pages.UserAccountPage;
import com.dfexamples.store_practice.Enums.TestUser;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void User_Can_Register_A_New_Account() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        AuthenticationPage.createAccountWithEmail();
        RegisterNewUserPage.registerUserWithPersonalAndShippingInfo();
    }

    @Test
    public void User_Can_Register_A_New_Account_And_Sign_Out() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        AuthenticationPage.createAccountWithEmail();
        RegisterNewUserPage.registerUserWithPersonalAndShippingInfo();
        UserAccountPage.signOut();
    }

    @Test
    public void User_Can_Register_Sign_Out_And_Log_Back_In() {

        HomePage.goTo();
        HomePage.selectSignInLink();
        String email = AuthenticationPage.createAccountWithEmail();
        RegisterNewUserPage.registerUserWithPersonalAndShippingInfo();
        UserAccountPage.signOut();
        AuthenticationPage.loginWith(email, TestUser.USER_W_GOOD_INFO.getPassword());
    }
}