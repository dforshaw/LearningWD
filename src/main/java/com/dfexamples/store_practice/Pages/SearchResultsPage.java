package com.dfexamples.store_practice.Pages;

import org.openqa.selenium.By;

import static com.dfexamples.Framework.Utilities.Common.getText;
import static com.dfexamples.Framework.Utilities.Common.getTitle;
import static com.dfexamples.Framework.Utilities.Common.waitForVisible;

public class SearchResultsPage {

    private static By searchResultRows = By.cssSelector(".product-container > .row");
    private static By navigationLink = By.cssSelector(".navigation_page");
    private static By searchCriteria = By.cssSelector(".page-heading.product-listing");

    public static Boolean isAt() {
        waitForVisible(navigationLink, 10);

        String title = getTitle();
        if (title.equalsIgnoreCase("Search - My Store")) {
//            System.out.println("On Search Results page");
            return true;
        }
        else return false;
    }

    public static String getSearchCriteria() {
        return getText(searchCriteria);
    }

// IN PROGRESS
//    public static void chooseResultFromList(String choice) {
//        List<WebElement> resultsList = DriverManager.DriverInstance.findElements(searchResultRows);
//
//        for (int i = 0; i < resultsList.size(); i++) {
//            if (resultsList.get(i).getText().equals(choice)) {
//                resultsList.get(i).findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default>span")).click();
//            }
//        }
//    }
}