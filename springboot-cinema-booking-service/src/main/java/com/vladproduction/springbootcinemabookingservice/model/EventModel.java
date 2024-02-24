package com.vladproduction.springbootcinemabookingservice.model;

import java.time.LocalDate;

/**
 * describe event stands in ticket for booking service;
 * */

public interface EventModel extends Entity{

    String getTitle();
    void setTitle(String title);
    LocalDate getDate();
    void setDate(LocalDate localDate);

}
