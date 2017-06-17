package com.dfexamples.eviltester;

public interface Config {

    final String baseUrl = System.getProperty("baseUrl","http://www.compendiumdev.co.uk/selenium/testpages");

    final String browser = System.getProperty("browser", "Firefox");
}
