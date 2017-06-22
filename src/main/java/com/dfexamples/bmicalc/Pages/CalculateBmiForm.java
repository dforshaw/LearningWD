package com.dfexamples.bmicalc.Pages;

import com.dfexamples.testtheinternet.Framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculateBmiForm {

    By heightCMSLocator = By.id("heightCMS");
    By weightKgLocator = By.id("weightKg");
    By calculateButtonLocator = By.id("Calculate");
    By bmiLabelLocator = By.id("bmi");
    By bmiCategoryLabelLocator = By.id("bmi_category");


    private final String heightToUse;
    private final String weightToUse;

    public CalculateBmiForm(String enteredHeight, String enteredWeight){

        this.heightToUse = enteredHeight;
        this.weightToUse = enteredWeight;
    }

    public void Compute() {

        clear_field(heightCMSLocator);
        enter_text(heightCMSLocator, heightToUse);

        clear_field(weightKgLocator);
        enter_text(weightKgLocator, weightToUse);

        find_field(calculateButtonLocator).click();
    }

    public String getBmi() {
        return bmiLabelLocator.toString();
    }

    public String getBmiCategory() {
        return bmiCategoryLabelLocator.toString();
    }


    private WebElement find_field(By locator) {
        return DriverManager.DriverInstance.findElement(locator);
    }

    private void clear_field(By locator) {
        find_field(locator).clear();
    }

    private void enter_text(By locator, String text) {
        find_field(locator).sendKeys(text);
    }
}


