package com.dfexamples.Framework.Utilities;

public class CreateEmail {

    public static String generate(String em) {
        if (em.isEmpty()) {
            em = "df012668+" + Time.getCurrentDateTimeAsString() + "@gmail.com";
        }
        return em;
    }
}