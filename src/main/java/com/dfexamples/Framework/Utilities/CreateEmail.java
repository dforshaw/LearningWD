package com.dfexamples.Framework.Utilities;

import java.util.Random;

public class CreateEmail {

    public static String generate() {
        Random randomNumber = new Random();
        Integer extra = randomNumber.nextInt(1000000);
        System.out.println(extra);
        return "df012668+" + Time.getCurrentDateAsString() + extra + "@gmail.com";
    }
}