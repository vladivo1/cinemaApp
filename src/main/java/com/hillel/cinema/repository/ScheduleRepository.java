package com.hillel.cinema.repository;

import com.hillel.cinema.model.Movie;
import com.hillel.cinema.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    public Schedule getScheduleByMovie (Movie movie);
    public Schedule getScheduleByMovieTime (LocalDateTime movieTime);
}
