package com.dfexamples.Framework;

import java.util.Optional;
import java.util.Properties;

import static com.dfexamples.Framework.Enums.BrowserChoice.BROWSER_CHROME;

public class PropertyManager {

    private static Properties properties = new Properties();
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_BROWSER = BROWSER_CHROME.getBrowser();

    public static String getProperty(String key) {
        if (properties.isEmpty()) {
            PropertyManager.Initialize();
        }

        return properties.getProperty(key);
    }

    private static void Initialize() {
        String host;
        String browser;
        String os;

        host = Optional.ofNullable(System.getProperty("targetHost")).orElse(DEFAULT_HOST);
        browser = Optional.ofNullable(System.getProperty("browserType")).orElse(DEFAULT_BROWSER);
        os = System.getProperty("os.name").toUpperCase();

        properties.setProperty("SelectedHost", host);
        properties.setProperty("SelectedBrowser", browser);
        properties.setProperty("operating_system", os);
    }
}
