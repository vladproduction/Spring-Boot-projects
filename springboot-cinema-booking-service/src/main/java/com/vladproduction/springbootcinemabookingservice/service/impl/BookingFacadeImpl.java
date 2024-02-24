package com.vladproduction.springbootcinemabookingservice.service.impl;


import com.vladproduction.springbootcinemabookingservice.model.impl.Event;
import com.vladproduction.springbootcinemabookingservice.model.impl.Ticket;
import com.vladproduction.springbootcinemabookingservice.model.impl.User;
import com.vladproduction.springbootcinemabookingservice.model.impl.UserAccount;
import com.vladproduction.springbootcinemabookingservice.service.EventService;
import com.vladproduction.springbootcinemabookingservice.service.UserAccountService;
import com.vladproduction.springbootcinemabookingservice.service.facade.BookingFacade;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
@Service
public class BookingFacadeImpl implements BookingFacade {

    private final UserServiceImpl userService;

    private final EventService eventService;

    private final TicketServiceImpl ticketService;

    private final UserAccountService accountService;



    @Override
    public Event getEventById(long eventId) {
        log.info("in facade was called getEventById method");
        return eventService.getById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        log.info("in facade was called getEventByTitle method");
        return eventService.getEventsByTitle(title,pageSize,pageNum);
    }

    @Override
    public List<Event> getEventsForDay(LocalDate day, int pageSize, int pageNum) {
        log.info("in facade was called getEventForDay method");
        return eventService.getEventsForDay(day,pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        log.info("in facade was called createEvent method");
        return eventService.create(event);
    }

    @Override
    public Event updateEvent(Event event) {
        log.info("in facade was called createEvent method");
        return eventService.create(event);
    }


    @Override
    public boolean deleteEvent(long eventId) {
        log.info("in facade was called deleteEvent method");
        return eventService.deleteById(eventId);
    }

    @Override
    public User getUserById(long userId) {
        log.info("in facade was called getUserById method");
        return userService.getById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        log.info("in facade was called getUserByEmail method");
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        log.info("in facade was called getUserByName method");
        return userService.getUsersByName(name, pageSize,pageNum);
    }

    @Override
    public User createUser(User user) {
        log.info("in facade was called createUser method");
        return userService.create(user);
    }

    @Override
    public User updateUser(long id,User user) {
        log.info("in facade was called updateUser method");
        return userService.updateById(id, user);
    }

    @Override
    public boolean deleteUser(long userId) {
        log.info("in facade was called deleteByIdUser method");
        return userService.deleteById(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place) {
        log.info("in facade was called bookTicket method");
        return ticketService.bookTicket(userId, eventId, place);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        log.info("in facade was called getBookedTicket  byUser method");
        return ticketService.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        log.info("in facade was called bookTicket by Event method");
        return ticketService.getBookedTickets(event,pageSize,pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        log.info("in facade was called cancelTicket method");
        return ticketService.cancelTicket(ticketId);
    }

    public Double refillAccountBalance(UserAccount account, Double amount){
        log.info("in facade was called refile account method");
        return accountService.refillAccount(account,amount);
    }

    public UserAccount createUserAccount(UserAccount account){
        return accountService.create(account);
    }
}
