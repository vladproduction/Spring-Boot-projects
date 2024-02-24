package com.vladproduction.springbootcinemabookingservice.service.impl;



import com.vladproduction.springbootcinemabookingservice.exception.BalanceNotEnoughMoneyException;
import com.vladproduction.springbootcinemabookingservice.exception.EventNotFoundException;
import com.vladproduction.springbootcinemabookingservice.exception.TicketNotFoundException;
import com.vladproduction.springbootcinemabookingservice.exception.UserNotFoundException;
import com.vladproduction.springbootcinemabookingservice.model.impl.Event;
import com.vladproduction.springbootcinemabookingservice.model.impl.Ticket;
import com.vladproduction.springbootcinemabookingservice.model.impl.User;
import com.vladproduction.springbootcinemabookingservice.model.impl.UserAccount;
import com.vladproduction.springbootcinemabookingservice.repository.EventRepository;
import com.vladproduction.springbootcinemabookingservice.repository.TicketRepository;
import com.vladproduction.springbootcinemabookingservice.repository.UserAccountRepository;
import com.vladproduction.springbootcinemabookingservice.repository.UserRepository;
import com.vladproduction.springbootcinemabookingservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final UserRepository userRepository;

    private final UserAccountRepository accountRepository;

    private final EventRepository eventRepository;

    @Override
    public Ticket getById(long id) {
        log.info("find ticket by id {}", id);
        Ticket persistedTicket = ticketRepository
                .findById(id)
                .orElseThrow(() -> new TicketNotFoundException("ticket was not found, id:" + id));
        log.info("ticket was found, id {}", id);
        return persistedTicket;
    }

    @Override
    @Transactional
    public Ticket create(Ticket ticket) {
        log.info("creating ticket starts");

        User userPersisted = userRepository
                .findById(ticket.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        Event eventPersisted = eventRepository
                .findById(ticket.getId())
                .orElseThrow(() -> new EventNotFoundException("event not found"));
        ticket.setUser(userPersisted);
        ticket.setEvent(eventPersisted);
        Ticket ticketPersisted = ticketRepository.save(ticket);
        log.info("creating ticket {} completed", ticketPersisted);
        return null;
    }

    @Override
    public Ticket updateById(long id, Ticket entityDto) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    @Transactional
    public Ticket bookTicket(long userId, long eventId, int place) {
        log.info("booking ticket starts with userId{}, eventId{},place{}", userId, eventId, place);
        User userPersisted = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found,requested id:  " + userId));

        Event eventPersisted = eventRepository
                .findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("event not found, requested id:" + eventId));

        Double ticketPrice = eventPersisted.getTicketPrice();
        Double balance = userPersisted.getAccount().getBalance();

        if (ticketPrice *place > balance){
            throw new BalanceNotEnoughMoneyException("There is not enough money in your account");
        }else{
            UserAccount account = userPersisted.getAccount();
            account.setBalance(balance-ticketPrice*place);
            accountRepository.save(account);
        }
        Ticket ticket = getTicketModel(place, userPersisted, eventPersisted);
        Ticket ticketPersisted = ticketRepository.save(ticket);
        log.info("booking ticked completed, ticket {} was saved", ticketPersisted);

        return ticketPersisted;
    }

    private static Ticket getTicketModel(int place, User userPersisted, Event eventPersisted) {
        Ticket ticket = new Ticket();
        ticket.setEvent(eventPersisted);
        ticket.setUser(userPersisted);
        ticket.setPlace(place);
        return ticket;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        log.info("finding booked tickets by user {} starts", user);
        User userPersisted = userRepository
                .findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("user not found,requested id:  " + user.getId()));
        List<Ticket> ticketModelByUser = ticketRepository.findTicketByUser(userPersisted);
        log.info("booked tickets by user {} were found", user);
        return ticketModelByUser;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        log.info("finding booked tickets by event {} starts", event);
        Event eventPersisted = eventRepository
                .findById(event.getId())
                .orElseThrow(() -> new EventNotFoundException("event was not found, id" + event.getId()));
        List<Ticket> tickets = ticketRepository.findTicketByEvent(eventPersisted);
        log.info("booked tickets by event {} were found", event);
        return tickets;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        ticketRepository.deleteById(ticketId);
        if (ticketRepository.existsById(ticketId)) {
            log.info("ticket was with id {} not deleted", ticketId);
            return false;
        } else {
            log.info("ticket with id {} was deleted", ticketId);
            return true;
        }
    }
}
