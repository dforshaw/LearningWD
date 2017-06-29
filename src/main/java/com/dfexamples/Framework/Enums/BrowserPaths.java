package com.dfexamples.Framework.Enums;

import static com.dfexamples.Framework.Enums.CommonPaths.USER_HOME_DIRECTORY;

public enum BrowserPaths {
    WEBDRIVER_CLIENTS("/_webdriver_clients"),
    WEBDRIVER_CLIENT_PATH(USER_HOME_DIRECTORY.getPath() + WEBDRIVER_CLIENTS.getPath()),
    CHROME_DRIVER_PATH("/chromedriver"),
    GECKO_DRIVER_PATH("/geckodriver");

    String path;

    private BrowserPaths(String path_to_use) {
        this.path = path_to_use;
    }

    public String getPath() {
        return path;
    }
}
