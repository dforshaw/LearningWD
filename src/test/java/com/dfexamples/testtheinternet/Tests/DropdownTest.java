package com.dfexamples.testtheinternet.Tests;

import com.dfexamples.testtheinternet.Pages.DropdownPage;
import org.junit.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void User_Can_Access_Dropdown_List_Page() {
        DropdownPage.GoTo();
    }

    @Test
    public void User_Can_Select_From_A_Dropdown_List() {
        DropdownPage.GoTo();
        DropdownPage.SelectFromDropdown("Option 3");
    }
}

