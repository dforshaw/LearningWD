package com.dfexamples.bmicalc.Pages;

import com.dfexamples.Framework.DriverManager;
import com.dfexamples.bmicalc.Enums.TestURL;

import static org.assertj.core.api.Assertions.assertThat;

public class BmiCalculatorPage {

    public static void GoTo() {
        DriverManager.DriverInstance.navigate().to(TestURL.BASE_ADDRESS.getUrl());
        String pageTitle = DriverManager.DriverInstance.getTitle();
        System.out.println(pageTitle);
        assertThat(pageTitle).isEqualToIgnoringCase("BMI Calculator");
    }

//    public static CalculateBmiForm CalculateBmi(String height, String weight) {
//
//        return new CalculateBmiForm(height, weight);
//    }
}
