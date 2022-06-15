package com.demo.trackzilla.service;

import com.demo.trackzilla.entity.Ticket;
import com.demo.trackzilla.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

//    @Override
//    public Iterable<Ticket> listTickets() {
//        return ticketRepository.findAll();
//    }

    @Override
    public List<Ticket> listTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

}
