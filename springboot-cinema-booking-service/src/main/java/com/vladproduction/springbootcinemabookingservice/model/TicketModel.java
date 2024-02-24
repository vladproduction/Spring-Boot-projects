package com.vladproduction.springbootcinemabookingservice.model;

import com.vladproduction.springbootcinemabookingservice.model.impl.TicketCategory;

/**
 * describe cinema ticket for booking service;
 * */

public interface TicketModel extends Entity{

    TicketCategory getTicketCategory();
    void  setTicketCategory(TicketCategory ticketCategory);
    int getPlace();
    void setPlace(int place);
}
