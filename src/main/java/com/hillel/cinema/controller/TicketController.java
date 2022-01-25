package com.hillel.cinema.controller;

import com.hillel.cinema.exception.EntityNotFoundException;
import com.hillel.cinema.model.Client;
import com.hillel.cinema.model.Ticket;
import com.hillel.cinema.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {
    public final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket saveTicket (@RequestBody Ticket ticket) {
        return ticketService.saveTicket(ticket);

    }

    @GetMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket getTicketById(@PathVariable Long id) throws EntityNotFoundException {
        return ticketService.getTicketById(id);

    }

    @GetMapping("/tickets/{client}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket getTicketById(@PathVariable Client client) throws EntityNotFoundException {
        return ticketService.getTicketByClient(client);

    }

    @GetMapping("/tickets")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();

    }

    @PutMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket updateTicketById(@PathVariable("id") Long id, @RequestBody Ticket ticket) throws EntityNotFoundException {
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteTicketById(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Билет с id" + id + " удалён!");
    }
}
