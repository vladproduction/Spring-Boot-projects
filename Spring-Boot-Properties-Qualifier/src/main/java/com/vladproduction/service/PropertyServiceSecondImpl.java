package com.vladproduction.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("SecondService")
public class PropertyServiceSecondImpl implements PropertyService {

    //reading from which file of property depends, of which profile is active
    @Value(value = "${contextApp.profile.property2:This is default value for absent property}")
    private String value;
    @Override
    public String getPropertyValue() {
        return value;
    }
}
