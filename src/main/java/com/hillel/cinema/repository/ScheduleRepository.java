package com.hillel.cinema.repository;

import com.hillel.cinema.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Integer, Schedule> {
}
