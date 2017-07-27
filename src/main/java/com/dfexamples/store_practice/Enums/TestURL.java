package com.dfexamples.store_practice.Enums;

public enum TestURL {

    BASE_ADDRESS("http://automationpractice.com"),
    HOME_PAGE("/"),
    AUTHENTICATION_PAGE("/index.php?controller=authentication"),
    LOGIN_PAGE("/login"),
    REGISTER_PAGE("/login");

    String url;

    private TestURL(String url_to_use) {
        this.url = url_to_use;
    }

    public String getUrl() {
        return url;
    }
}
