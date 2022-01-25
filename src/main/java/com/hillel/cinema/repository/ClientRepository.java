package com.hillel.cinema.repository;

import com.hillel.cinema.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByEmail(String email);
    Client findClientByPhoneNumber(String phoneNumber);

}
