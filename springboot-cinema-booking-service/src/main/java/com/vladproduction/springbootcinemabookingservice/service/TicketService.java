package com.vladproduction.springbootcinemabookingservice.service;


import com.vladproduction.springbootcinemabookingservice.model.impl.Event;
import com.vladproduction.springbootcinemabookingservice.model.impl.Ticket;
import com.vladproduction.springbootcinemabookingservice.model.impl.User;

import java.util.List;

public interface TicketService extends CrudService<Ticket> {
    Ticket bookTicket(long userId, long eventId, int place);

    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);

    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);

    boolean cancelTicket(long ticketId);
}
