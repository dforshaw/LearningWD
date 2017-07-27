package com.dfexamples.testtheinternet.Pages;

import com.dfexamples.Framework.DriverManager;

import static com.dfexamples.testtheinternet.Enums.TestURL.BASE_ADDRESS;
import static com.dfexamples.testtheinternet.Enums.TestURL.MAIN_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    public static void goTo() {
        DriverManager.DriverInstance.navigate().to(BASE_ADDRESS.getUrl() + MAIN_PAGE.getUrl());
        assertThat(DriverManager.DriverInstance.getTitle()).isEqualToIgnoringCase("The Internet");
    }
}
