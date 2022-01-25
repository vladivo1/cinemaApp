package com.hillel.cinema.web;

import com.hillel.cinema.domain.Movie;
import com.hillel.cinema.domain.Schedule;
import com.hillel.cinema.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule saveSchedule (@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);

    }

    @GetMapping("/schedules/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Schedule getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);

    }

    @GetMapping("/schedules/{movie}")
    @ResponseStatus(HttpStatus.OK)
    public Schedule getScheduleByMovie(@PathVariable Movie movie) {
        return scheduleService.getScheduleByMovie(movie);

    }

    @GetMapping("/schedules/{movie_time}")
    @ResponseStatus(HttpStatus.OK)
    public Schedule getScheduleByMovieTime(@PathVariable LocalDateTime movie_time) {
        return scheduleService.getScheduleByMovieTime(movie_time);

    }

    @GetMapping("/schedules")
    @ResponseStatus(HttpStatus.OK)
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();

    }

    @PutMapping("/schedules/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Schedule updateScheduleById(@PathVariable("id") Long id, @RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/schedules/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteScheduleById(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("Расписание с id" + id + " удалено!");
    }
}
