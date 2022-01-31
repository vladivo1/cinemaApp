package com.hillel.cinema.service;

import com.hillel.cinema.domain.User;
import com.hillel.cinema.domain.Ticket;
import com.hillel.cinema.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.persistence.*;

@Service @RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id)  {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Билет с id " + id + " не найден"));
    }

    public Ticket getTicketByUser(User user) {
        Ticket ticket = ticketRepository.getTicketByUser(user);
        if (user == null)
            throw new EntityNotFoundException("Билет клиента не найден");
        return ticket;
    }

    public Ticket updateTicket(Long id,Ticket ticket)  {
        return ticketRepository.findById(id)
                .map(entity ->{

                   entity.setUser(ticket.getUser());
                   entity.setCost(ticket.getCost());
                   entity.setDate(ticket.getDate());
                   entity.setMovieName(ticket.getMovieName());
                   entity.setRoom(ticket.getRoom());
                    return ticketRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Билет с id " + id + " не найден"));
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
