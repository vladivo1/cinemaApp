package com.hillel.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String cost;
    private String movieName;
    // TODO: 25.01.2022 Date and mb instant?
    private LocalDateTime date;
    private String room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

}
