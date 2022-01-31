package com.hillel.cinema.repository;
import com.hillel.cinema.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findMovieByTitle(String title);
}
