package com.vladproduction.carshearing.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    //loading from file properties and return as the String of method getConfigProperty(String key);
    public static String getConfigProperty(String key){

        try(InputStream inputStream = ConfigUtils.class.getResourceAsStream("/application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String value = properties.getProperty(key);
            return value;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
