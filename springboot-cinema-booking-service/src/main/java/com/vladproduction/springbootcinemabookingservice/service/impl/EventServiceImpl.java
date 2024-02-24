package com.vladproduction.springbootcinemabookingservice.service.impl;


import com.vladproduction.springbootcinemabookingservice.exception.EventAlreadyExistException;
import com.vladproduction.springbootcinemabookingservice.exception.EventNotFoundException;
import com.vladproduction.springbootcinemabookingservice.model.impl.Event;
import com.vladproduction.springbootcinemabookingservice.repository.EventRepository;
import com.vladproduction.springbootcinemabookingservice.service.EventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event getById(long id) {
        log.info("finding event By Id {} ", id);
        Event persistedEvent = eventRepository
                .findById(id)
                .orElseThrow(()-> new EventNotFoundException("event was not found, id "+id));
        log.info("event with id {} was found", id);
        return persistedEvent;
    }

    @Override
    @Transactional
    public Event create(Event eventDto) {
        log.info("eventService method createEvent {} was called", eventDto);
        if (eventRepository.existsById(eventDto.getId())) {
            throw new EventAlreadyExistException("Event with id {} is already exist" + eventDto.getId());
        }

        Event savedEvent = eventRepository.save(eventDto);
        log.info("event was created");
        return savedEvent;
    }

    @Override
    @Transactional
    public Event updateById(long id, Event eventDto) {
        log.info("eventService method updateById {} was called", id);
        Event persistedOldEvent =getById(id);
        Event updatedEvent = mapPersistedEventFieldsToEventDtoFields(persistedOldEvent, eventDto);
        return eventRepository.save(updatedEvent);
    }

    private Event mapPersistedEventFieldsToEventDtoFields(Event persistedEvent, Event eventNewDto) {
        String title = eventNewDto.getTitle();
        if (Objects.nonNull(title)) {
            persistedEvent.setTitle(title);
        }
        LocalDate date = eventNewDto.getDate();
        if (Objects.nonNull(date)) {
            persistedEvent.setDate(date);
        }
        return persistedEvent;
    }

    @Override
    @Transactional
    public boolean deleteById(long id) {
        log.info("eventService method deleteById {} was called", id);
        eventRepository.deleteById(id);
        if (eventRepository.existsById(id)) {
            log.info("event  with id {} was not deleted", id);
            return false;
        } else {
            log.info("event with id {} was deleted", id);
            return true;
        }
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        log.info("eventService method geEventByTitle  {} was called", title);
        return eventRepository.findEventByTitle(title);
    }

    @Override
    public List<Event> getEventsForDay(LocalDate day, int pageSize, int pageNum) {
        log.info("eventService method getForDay {} was called", day);
        return eventRepository.findEventByDate(day);
    }
}
