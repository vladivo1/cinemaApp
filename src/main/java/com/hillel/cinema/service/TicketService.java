package com.hillel.cinema.service;

import com.hillel.cinema.exception.EntityNotFoundException;
import com.hillel.cinema.model.Client;
import com.hillel.cinema.model.Ticket;
import com.hillel.cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket saveTicket(Ticket ticket){ return ticketRepository.save(ticket);}

    public List<Ticket> getAllTickets(){ return ticketRepository.findAll();}

    public Ticket getTicketById(Long id) throws EntityNotFoundException {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Билет с id " + id + " не найден"));
    }

    public Ticket getTicketByClient(Client client) throws EntityNotFoundException{
        Ticket ticket = ticketRepository.getTicketByClient(client);
        if (client == null)
            throw new EntityNotFoundException("Билет клиента не найден");
        return ticket;
    }

    public Ticket updateTicket(Long id,Ticket ticket) throws EntityNotFoundException {
        return ticketRepository.findById(id)
                .map(entity ->{

                   entity.setClient(ticket.getClient());
                   entity.setCost(ticket.getCost());
                   entity.setDate(ticket.getDate());
                   entity.setMovieName(ticket.getMovieName());
                   entity.setRoom(ticket.getRoom());
                   entity.setTime(ticket.getTime());
                    return ticketRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Билет с id " + id + " не найден"));
    }

    public void deleteTicket(Long id){ ticketRepository.deleteById(id); }
}
