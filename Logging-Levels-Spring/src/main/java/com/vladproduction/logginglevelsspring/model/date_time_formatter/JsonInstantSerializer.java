package com.vladproduction.logginglevelsspring.model.date_time_formatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by vladproduction on 12-Mar-24
 */

@JsonComponent
public class JsonInstantSerializer {

    private static final String DATE_FORMAT = "yyyy-MM-dd-HH.mm.ss";
    private static final String ZONE_ID = "Europe/Kyiv";

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT)
            .withZone(ZoneId.of(ZONE_ID));

    public static class InstantSerializer extends JsonSerializer<Instant> {
        @Override
        public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException {
            jsonGenerator.writeString(FORMATTER.format(instant));
        }
    }

    public static class InstantDeserializer extends JsonDeserializer<Instant> {
        @Override
        public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException, JacksonException {
            return Instant.from(FORMATTER.parse(jsonParser.getText()));
        }
    }

}
