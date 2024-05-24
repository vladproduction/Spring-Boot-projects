package com.vladproduction.filtercriteriaapi.helpers;

import com.vladproduction.filtercriteriaapi.model.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Field;
import java.util.Date;

public class HelperConfig {

    //helper method reflection approach
    //check if model field has a concrete type (Date)
    public static boolean isDateColumn(String columnName) {
        try {
            Class<?> entityClass = Employee.class; // entity class
            Field field = entityClass.getDeclaredField(columnName); // entity declared field
            return field.getType().equals(Date.class) // java.sql.Date depending on field type
                    || field.isAnnotationPresent(DateTimeFormat.class); // Check for @DateTimeFormat annotation
        } catch (NoSuchFieldException | SecurityException e) {
            return false;
        }
    }

    //helper method
    private boolean isDate(String value) {
        String regex = "^(\\d{4})-(\\d{2})-(\\d{2})$"; // YYYY-MM-DD format
        return value.matches(regex);
    }

}
