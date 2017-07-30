package com.dfexamples.store_practice.Enums;

public enum TestURL {

    HOME_PAGE("/");

    private final static String BASE_ADDRESS = "http://automationpractice.com";
    String url;

    private TestURL(String url_to_use) {
        this.url = url_to_use;
    }

    public String getUrl() {
        return BASE_ADDRESS + url;
    }
}
