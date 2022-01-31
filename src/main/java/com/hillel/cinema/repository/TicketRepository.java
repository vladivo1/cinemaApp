package com.hillel.cinema.repository;

import com.hillel.cinema.domain.User;
import com.hillel.cinema.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket getTicketByUser (User user);
}
