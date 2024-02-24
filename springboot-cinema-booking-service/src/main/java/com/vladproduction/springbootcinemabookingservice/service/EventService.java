package com.vladproduction.springbootcinemabookingservice.service;

import com.vladproduction.springbootcinemabookingservice.model.impl.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService extends CrudService<Event> {
    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);

    List<Event> getEventsForDay(LocalDate day, int pageSize, int pageNum);
}
