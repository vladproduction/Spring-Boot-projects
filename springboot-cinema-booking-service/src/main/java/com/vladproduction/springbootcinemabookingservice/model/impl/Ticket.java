package com.vladproduction.springbootcinemabookingservice.model.impl;

import com.vladproduction.springbootcinemabookingservice.model.TicketModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket implements TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int place;

    @Enumerated(EnumType.STRING)
    @ManyToOne
    @JoinColumn(name = "ticket_category_id", referencedColumnName = "id")
    private TicketCategory ticketCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;




}
