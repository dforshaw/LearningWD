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
}
