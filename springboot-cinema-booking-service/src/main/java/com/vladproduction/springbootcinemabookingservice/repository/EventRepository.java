package com.vladproduction.springbootcinemabookingservice.repository;

import com.vladproduction.springbootcinemabookingservice.model.impl.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventByTitle(String title);

    List<Event> findEventByDate(LocalDate day);

    @Override
    Optional<Event> findById(Long id);
}
