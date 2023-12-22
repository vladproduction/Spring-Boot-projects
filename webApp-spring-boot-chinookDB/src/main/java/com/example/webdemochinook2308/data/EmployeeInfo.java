package com.example.webdemochinook2308.data;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Employee}
 */
public interface EmployeeInfo {
    Integer getId();

    String getTitle();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}