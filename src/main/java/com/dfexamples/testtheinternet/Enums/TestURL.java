package com.dfexamples.testtheinternet.Enums;

public enum TestURL {

    BASE_ADDRESS("http://the-internet.herokuapp.com"),
    LOGIN_PAGE("/login"),
    DROPDOWN_PAGE("/dropdown"),
    MAIN_PAGE("/");

    String url;

    private TestURL(String url_to_use) {
        this.url = url_to_use;
    }

    public String getUrl() {
        return url;
    }
}
