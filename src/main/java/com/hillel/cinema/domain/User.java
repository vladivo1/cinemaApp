package com.hillel.cinema.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    public User(String firstName, String username, String password, String lastName, String email, Date dateOfBirth, String cartNumber, String phoneNumber, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.cartNumber = cartNumber;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    // TODO: 25.01.2022 возможно будет обьект
    private String cartNumber;
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Role> roles = new ArrayList<>();
}
