package com.vladproduction.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonConverter implements Converter {

    @Autowired
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
