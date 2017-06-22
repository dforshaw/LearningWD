package com.dfexamples.Framework.Enums;

public enum BrowserChoice {
    BROWSER_CHROME("Chrome"),
    BROWSER_MARIONETTE("Marionette"),
    BROWSER_FIREFOX("Firefox");

    String browser;

    private BrowserChoice(String browser_to_use) {
        this.browser = browser_to_use;
    }

    public String getBrowser() {
        return browser;
    }
}
