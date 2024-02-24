package com.vladproduction.springbootcinemabookingservice.model.impl;

import com.vladproduction.springbootcinemabookingservice.model.EventModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event implements EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private LocalDate date;

    private Double ticketPrice;

    @OneToMany(mappedBy="event", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Ticket> tickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id
                && Objects.equals(title, event.title)
                && Objects.equals(date, event.date)
                && Objects.equals(ticketPrice, event.ticketPrice)
                && Objects.equals(tickets, event.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, ticketPrice, tickets);
    }
}
