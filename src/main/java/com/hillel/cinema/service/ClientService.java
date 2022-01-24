package com.hillel.cinema.service;

import com.hillel.cinema.exception.UserAlreadyExistException;
import com.hillel.cinema.model.Client;
import com.hillel.cinema.repository.ClientRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) throws UserAlreadyExistException {
        if (clientRepository.findByEmail(client.getEmail()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким email уже существует");
        }
        else if (clientRepository.findByPhoneNumber(client.getPhoneNumber()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким номером телефона уже существует");
        } else

        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " not found"));
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
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id = " + id));

    }

    public Long deleteClient (Long id) {
         clientRepository.deleteById(id);
         return id;
    }

}
