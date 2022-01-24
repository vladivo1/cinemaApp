package com.hillel.cinema.repository;

import com.hillel.cinema.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findByEmail(String email);
    public Client findByPhoneNumber(String phoneNumber);

}
