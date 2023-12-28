package com.vladproduction.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.model.Person;

import java.util.List;

public class JsonConverter implements Converter {

    private ObjectMapper mapper;

    public JsonConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void init(){
        System.out.println("JsonConverter.init");
    }

    @Override
    public String convert(List<Person> personList) {
        try {
            return mapper.writeValueAsString(personList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
