package com.vladproduction.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeService {

    private static final String HH_MM_SS_24 = "HH:mm:ss"; // 24-hour format
    private static final String hh_mm_ss_12 = "hh:mm:ss a"; // 12-hour format with AM/PM
    private final boolean is24Hour;

    public TimeService(boolean is24Hour) {
        this.is24Hour = is24Hour;
    }

    public String getCurrentTime() {
        DateTimeFormatter formatter;
        if (is24Hour) {
            formatter = DateTimeFormatter.ofPattern(HH_MM_SS_24);
        }
        else {
            formatter = DateTimeFormatter.ofPattern(hh_mm_ss_12);
        }
        return LocalTime.now().format(formatter);
    }
}
