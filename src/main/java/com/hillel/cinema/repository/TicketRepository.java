package com.hillel.cinema.repository;

import com.hillel.cinema.model.Client;
import com.hillel.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public Ticket getTicketByClient (Client client);
}
