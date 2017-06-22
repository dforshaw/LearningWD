package com.dfexamples.framework.Enums;

public enum BrowserPaths {
    WEBDRIVER_CLIENTS("/_webdriver_clients"),
    CHROME_DRIVER_PATH("/chromedriver/chromedriver"),
    GECKO_DRIVER_PATH("/geckodriver/geckodriver");

    String path;

    private BrowserPaths(String path_to_use) {
        this.path = path_to_use;
    }

    public String getPath() {
        return path;
    }
}
