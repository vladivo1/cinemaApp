package com.hillel.cinema.service;

import com.hillel.cinema.exception.EntityNotFoundException;
import com.hillel.cinema.model.Movie;
import com.hillel.cinema.model.Schedule;
import com.hillel.cinema.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules(){ return scheduleRepository.findAll(); }

    public Schedule getScheduleById(Long id) throws EntityNotFoundException {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Расписание с id " + id + " не найдено"));
    }

    public Schedule getScheduleByMovie(Movie movie) throws EntityNotFoundException{
        Schedule schedule = scheduleRepository.getScheduleByMovie(movie);
        if (movie == null)
            throw new EntityNotFoundException("Расписание с таким фильмом не найдено");
        return schedule;
    }

    public Schedule getSchedulebyMovieTime(LocalDateTime movieTime) throws EntityNotFoundException{
        Schedule schedule = scheduleRepository.getScheduleByMovieTime(movieTime);
        if (movieTime == null)
            throw new EntityNotFoundException("Расписание по такому времени не найдено");
        return schedule;
    }

    public Schedule updateSchedule(Long id,Schedule schedule) throws EntityNotFoundException {
        return scheduleRepository.findById(id)
                .map(entity ->{

                    entity.setMovie(schedule.getMovie());
                    entity.setMovieTime(schedule.getMovieTime());
                    entity.setRoom(schedule.getRoom());
                    return scheduleRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Расписание с id " + id + " не найдено"));
    }

    public void deleteSchedule(Long id){ scheduleRepository.deleteById(id); }
}
