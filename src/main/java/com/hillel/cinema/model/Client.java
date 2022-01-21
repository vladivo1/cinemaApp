package com.hillel.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long clientId;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private long cartNumber;
    private long number;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Ticket> tickets = new HashSet<>();
}
