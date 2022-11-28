package com.maveric.userservice.utility;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.maveric.userservice.exception.InvalidException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateDeSerializer extends StdDeserializer<LocalDate> {
    public DateDeSerializer() {
        super(Date.class);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        String value = p.readValueAs(String.class);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(value,formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidException("Date format Miss Match Expected 'YYYY-MM-DD' ");
        }
    }
}
