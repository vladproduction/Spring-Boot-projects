package com.vladproduction.springbootcinemabookingservice.repository;

import com.vladproduction.springbootcinemabookingservice.model.impl.Event;
import com.vladproduction.springbootcinemabookingservice.model.impl.Ticket;
import com.vladproduction.springbootcinemabookingservice.model.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findTicketByUser(User user);

    List<Ticket> findTicketByEvent(Event event);
}
