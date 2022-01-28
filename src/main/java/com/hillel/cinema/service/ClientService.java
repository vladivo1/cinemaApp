package com.hillel.cinema.service;

import com.hillel.cinema.domain.Client;
import com.hillel.cinema.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.persistence.*;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id)  {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id  " + id + " не найден"));
    }

    public Client getClientByEmail (String email) {
        return clientRepository.findClientByEmail(email);

    }

    public Client getClientByNumber (String phoneNumber) {
        return clientRepository.findClientByPhoneNumber(phoneNumber);
    }

    public Client updateClientById (Long id, Client client) {
        return clientRepository.findById(id)
                .map(entity -> {

                        entity.setFirstName(client.getFirstName());
                        entity.setLastName(client.getLastName());
                        entity.setEmail(client.getEmail());
                        entity.setDateOfBirth(client.getDateOfBirth());
                        entity.setCartNumber(client.getCartNumber());
                        entity.setPhoneNumber(client.getPhoneNumber());
                        return clientRepository.save(entity);
                    })
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + id +  " не найден"));

    }

    public void deleteClient (Long id) {
         clientRepository.deleteById(id);
    }

}
