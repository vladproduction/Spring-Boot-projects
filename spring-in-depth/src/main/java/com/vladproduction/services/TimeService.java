package com.vladproduction.services;

import com.vladproduction.aspect.Countable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    private static final DateTimeFormatter FORMATTER_24 = DateTimeFormatter.ofPattern("HH:mm:ss"); // 24-hour format
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss a"); // 12-hour format with AM/PM

    @Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
    private boolean is24Hour;

    public TimeService() {
        super();
    }

    @Countable
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();

        if (is24Hour) {
            return FORMATTER_24.format(now);
        }
        return FORMATTER_12.format(now);
    }
}
