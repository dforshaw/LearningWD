package com.dfexamples.bmicalc.Enums;

public enum TestURL {

    BASE_ADDRESS("http://cookbook.seleniumacademy.com/bmicalculator.html"),
    MAIN_PAGE("/");

    String url;

    private TestURL(String url_to_use) {
        this.url = url_to_use;
    }

    public String getUrl() {
        return url;
    }
}
