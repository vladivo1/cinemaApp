package com.hillel.cinema.service;

import com.hillel.cinema.domain.Client;
import com.hillel.cinema.domain.Ticket;
import com.hillel.cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id)  {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("Билет с id " + id + " не найден"));
    }

    public Ticket getTicketByClient(Client client) {
        Ticket ticket = ticketRepository.getTicketByClient(client);
        if (client == null)
            throw new javax.persistence.EntityNotFoundException("Билет клиента не найден");
        return ticket;
    }

    public Ticket updateTicket(Long id,Ticket ticket)  {
        return ticketRepository.findById(id)
                .map(entity ->{

                   entity.setClient(ticket.getClient());
                   entity.setCost(ticket.getCost());
                   entity.setDate(ticket.getDate());
                   entity.setMovieName(ticket.getMovieName());
                   entity.setRoom(ticket.getRoom());
                    return ticketRepository.save(entity);
                })
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("Билет с id " + id + " не найден"));
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
