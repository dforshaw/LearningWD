package com.dfexamples.Framework.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static Integer getCurrentTimeAs24HourInteger(){

        String currentTime = new SimpleDateFormat("Hmm").format(new Date());

        return Integer.parseInt(currentTime);
    }

    public static String getCurrentDateTimeAsString() {

        String currentDateTime = new SimpleDateFormat("yMMddHHmmsS").format(new Date());

        return currentDateTime;
    }

    public static String getCurrentDateTimeAsStringForReporting() {

        String currentDateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());

        return currentDateTime;
    }

    public static String getCurrentDateAsString() {

        String currentDateTime = new SimpleDateFormat("yMMdd").format(new Date());

        return currentDateTime;
    }
}
