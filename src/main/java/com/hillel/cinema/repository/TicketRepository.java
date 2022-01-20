package com.hillel.cinema.repository;

import com.hillel.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Integer, Ticket> {
}
