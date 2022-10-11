package com.maveric.userservice.constants;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.maveric.userservice.exception.InvalidException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateDeSerializer extends StdDeserializer<LocalDateTime> {
    public DateDeSerializer() {
        super(Date.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String value = p.readValueAs(String.class);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("formatter"+formatter);
            LocalDate date = LocalDate.parse(value, formatter);
            LocalDateTime localDateTime = date.atStartOfDay();

            System.out.println("date"+date);
            return localDateTime;
        } catch (DateTimeParseException e) {

            System.out.println("Exception "+e);
            throw new InvalidException("Date format Miss Match Expected 'YYYY-MM-DD' ");
        }
    }
}
