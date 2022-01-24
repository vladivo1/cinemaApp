package com.hillel.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private double cost;
    private String movieName;
    private double date;
    private double time;
    private int room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "clientId")
    private Client client;

}
