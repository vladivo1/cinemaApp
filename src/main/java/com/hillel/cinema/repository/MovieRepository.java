package com.hillel.cinema.repository;
import com.hillel.cinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Movie findMovieByTitle(String title);
}
