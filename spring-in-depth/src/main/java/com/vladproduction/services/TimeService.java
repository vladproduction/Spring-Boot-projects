package com.vladproduction.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeService {

    public static final String HH_MM_SS = "HH:mm:ss";

    public TimeService(boolean active) {
    }

    public String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(HH_MM_SS));
    }
}
