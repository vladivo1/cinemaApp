package com.hillel.cinema.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // TODO: 25.01.2022 изменить на Data?
    private String date;
    @ManyToOne
    private Movie movie;
    // TODO: 25.01.2022 изменить на fk?
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    // TODO: 25.01.2022 String or start and end?
    @Column(name = "movie_time")
    private LocalDateTime movieTime;

}