package com.dfexamples.store_practice.tests;

import com.dfexamples.store_practice.Pages.HomePage;
import com.dfexamples.store_practice.Pages.SearchResultsPage;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    @Test
    public void Search_Results_Match_Users_Criteria() {

        HomePage.goTo();
        HomePage.searchFor("yellow");

        assertThat(SearchResultsPage.getSearchCriteria()).contains("yellow");
    }
}