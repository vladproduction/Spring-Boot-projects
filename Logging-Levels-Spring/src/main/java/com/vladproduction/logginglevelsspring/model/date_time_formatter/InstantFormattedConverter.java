package com.vladproduction.logginglevelsspring.model.date_time_formatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class InstantFormattedConverter implements Converter<String, Instant> {

    @Override
    public Instant convert(String value) {
        return Instant.from(JsonInstantSerializer.FORMATTER.parse(value));
    }
}
