package com.dfexamples.store_practice.Enums;

public enum TestURL {

    BASE_ADDRESS("http://automationpractice.com"),
    HOME_PAGE("/");

    String url;

    private TestURL(String url_to_use) {
        this.url = url_to_use;
    }

    public String getUrl() {
        return url;
    }
}
