package com.hillel.cinema.web;
import com.hillel.cinema.domain.Client;
import com.hillel.cinema.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);

    }

    @GetMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);

    }

    @GetMapping("/clients/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email);

    }

    @GetMapping("/clients/{phone_number}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientByPhoneNumber(@PathVariable String phone_number) {
        return clientService.getClientByNumber(phone_number);

    }

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients() {
        return clientService.getAllClients();

    }

    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client updateClientById(@PathVariable("id") Long id, @RequestBody Client client)  {
        return clientService.updateClientById(id, client);
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteClientById(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Пользователь с id" + id + " удален!");
    }

}
