package com.hillel.cinema.repository;

import com.hillel.cinema.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findClientByEmail(String email);
    public Client findClientByPhoneNumber(String phoneNumber);

}
