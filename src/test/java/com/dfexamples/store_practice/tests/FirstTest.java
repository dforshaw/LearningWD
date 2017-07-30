package com.dfexamples.store_practice.tests;

import com.dfexamples.Framework.Utilities.CreateEmail;
import com.dfexamples.store_practice.Enums.TestURL;
import org.junit.Ignore;
import org.junit.Test;

import static com.dfexamples.Framework.Utilities.Common.getTitle;
import static com.dfexamples.Framework.Utilities.Common.navTo;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest extends BaseTest {

    @Ignore
    @Test
    public void Initial_Navigation_Test() {
        String home_page_url = TestURL.HOME_PAGE.getUrl();
        String home_page_title = "My Store";
        navTo(home_page_url);
        assertThat(getTitle()).isEqualToIgnoringCase(home_page_title);
    }

    @Ignore
    @Test
    public void Email_Creation_Test() {
        String email = "";

        email = CreateEmail.generate("");

        System.out.println(email);
    }
}
