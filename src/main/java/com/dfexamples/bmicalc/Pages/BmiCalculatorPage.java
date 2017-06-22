package com.dfexamples.bmicalc.Pages;

import com.dfexamples.bmicalc.Framework.DriverManager;
import org.openqa.selenium.By;

import static com.dfexamples.bmicalc.Framework.DriverManager.BaseAddress;
import static org.assertj.core.api.Assertions.assertThat;

public class BmiCalculatorPage {

    public static void GoTo() {
        DriverManager.DriverInstance.navigate().to(BaseAddress);
        String pageTitle = DriverManager.DriverInstance.getTitle();
        System.out.println(pageTitle);
        assertThat(pageTitle).isEqualToIgnoringCase("BMI Calculator");
    }

    public static CalculateBmiForm CalculateBmi(String height, String weight) {

        return new CalculateBmiForm(height, weight);
    }
}
