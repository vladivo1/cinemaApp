package com.hillel.cinema.repository;

import com.hillel.cinema.domain.Movie;
import com.hillel.cinema.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Schedule getScheduleByMovie (Movie movie);
    Schedule getScheduleByDate (String date);
}
