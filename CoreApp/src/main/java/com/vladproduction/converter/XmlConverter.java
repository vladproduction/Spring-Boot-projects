package com.vladproduction.converter;

import com.vladproduction.model.Person;

import java.util.List;

public class XmlConverter implements Converter {

    @Override
    public String convert(List<Person> personList) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<persons>");
        for (Person person: personList){
            sb.append(toXml(person));
        }
        sb.append("</persons>");
        return sb.toString();
    }

    private String toXml(Person person){
        String template = "<Person><name>%s</name><age>%s</age></Person>";
        return String.format(template, person.getName(), person.getAge());
    }
}
