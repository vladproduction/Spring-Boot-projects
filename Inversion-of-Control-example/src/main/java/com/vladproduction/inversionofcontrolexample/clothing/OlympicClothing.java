package com.vladproduction.inversionofcontrolexample.clothing;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Component
public class OlympicClothing {

    //without configuration XML file

    private List<Cloth> cloths;

    @Bean
    public void setList(){
        this.cloths = new ArrayList<>();

        cloths.add(new Cloth("Олимпийская", "Зеленая", "Спортивная", "Куртка"));
        cloths.add(new Cloth("Олимпийская", "Синяя", "Спортивная", "Шапка"));
        cloths.add(new Cloth("Олимпийская", "Желтая", "Спортивная", "Шарф"));
        cloths.add(new Cloth("Олимпийская", "Оранжевая", "Спортивная", "Футболка"));
    }

    public OlympicClothing() {
    }

    @Bean
    public void printClothes(){
        for (Cloth cloth : cloths) {
            System.out.println(cloth);
        }
    }
}
