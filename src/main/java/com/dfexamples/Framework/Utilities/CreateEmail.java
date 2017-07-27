package com.dfexamples.Framework.Utilities;

public class CreateEmail {

    public static String generate() {
        return "df012668+" + Time.getCurrentDateTimeAsString() + "@gmail.com";
    }
}
