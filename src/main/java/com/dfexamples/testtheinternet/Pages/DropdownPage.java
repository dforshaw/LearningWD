package com.dfexamples.testtheinternet.Pages;

import com.dfexamples.Framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.dfexamples.testtheinternet.Enums.TestURL.BASE_ADDRESS;
import static com.dfexamples.testtheinternet.Enums.TestURL.DROPDOWN_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class DropdownPage {

    private static By pageNameSelector = By.cssSelector(".example > h3");
    private static By dropdownListSelector = By.id("dropdown");
    private static By dropdownOptionsSelector = By.tagName("option");

    public static void goTo() {
        DriverManager.DriverInstance.navigate().to(BASE_ADDRESS.getUrl() + DROPDOWN_PAGE.getUrl());
        assertThat(DriverManager.DriverInstance.findElement(pageNameSelector).getText()).isEqualToIgnoringCase("Dropdown List");
    }

    public static void selectFromDropdown(String choice) {
        WebElement dropdownList = DriverManager.DriverInstance.findElement(dropdownListSelector);
        List<WebElement> options = dropdownList.findElements(dropdownOptionsSelector);

        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals(choice)) {
                options.get(i).click();
            }
        }

        verifyDropdownSelectionIs(choice);
    }

    public static void verifyDropdownSelectionIs(String selection) {
        WebElement dropdownList = DriverManager.DriverInstance.findElement(dropdownListSelector);
        List<WebElement> options = dropdownList.findElements(dropdownOptionsSelector);
        String selectedOption = "";

        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = options.get(i).getText();
                System.out.println(selectedOption);
            }
        }

        assertThat(selectedOption).isEqualToIgnoringCase(selection);
    }

}
