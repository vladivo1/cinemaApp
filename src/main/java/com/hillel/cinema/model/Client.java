package com.hillel.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String cartNumber;
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Ticket> tickets = new HashSet<>();
}
