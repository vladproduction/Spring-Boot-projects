package com.vladproduction.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("FirstService")
public class PropertyServiceFirstImpl implements PropertyService {

    @Value(value = "${contextApp.profile.property}") //reading from which file of property depends, of which profile is active
    private String value;
    @Override
    public String getPropertyValue() {
        return value;
    }
}
