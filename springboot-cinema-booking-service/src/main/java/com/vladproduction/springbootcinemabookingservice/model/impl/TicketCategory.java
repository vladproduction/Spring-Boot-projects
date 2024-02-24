package com.vladproduction.springbootcinemabookingservice.model.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketCategory {

    @Id
    @GeneratedValue
    private int id;

    private String category;

    @OneToMany(mappedBy = "ticketCategory")
    @ToString.Exclude
    private Set<Ticket> tickets;
}
