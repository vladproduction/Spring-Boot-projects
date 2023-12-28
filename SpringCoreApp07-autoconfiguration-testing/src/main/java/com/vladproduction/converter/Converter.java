package com.vladproduction.converter;

import com.vladproduction.model.Person;

import java.util.List;

public interface Converter {

    String convert(List<Person> personList);
}
