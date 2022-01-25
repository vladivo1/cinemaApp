package com.hillel.cinema.web;

import com.hillel.cinema.domain.Client;
import com.hillel.cinema.domain.Ticket;
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
    public Ticket getTicketById(@PathVariable Long id)  {
        return ticketService.getTicketById(id);

    }

    @GetMapping("/tickets/{client}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket getTicketById(@PathVariable Client client)  {
        return ticketService.getTicketByClient(client);

    }

    @GetMapping("/tickets")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();

    }

    @PutMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket updateTicketById(@PathVariable("id") Long id, @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteTicketById(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Билет с id" + id + " удалён!");
    }
}
