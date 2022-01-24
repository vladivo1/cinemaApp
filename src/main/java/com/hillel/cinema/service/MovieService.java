package com.hillel.cinema.service;

import com.hillel.cinema.exception.EntityNotFoundException;
import com.hillel.cinema.model.Movie;
import com.hillel.cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);

    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) throws EntityNotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Фильм с id " + id + " не найден"));
    }

    public Movie getMovieByTitle(String title) throws EntityNotFoundException {
        Movie movie = movieRepository.findMovieByTitle(title);
        if (title == null)
            throw new EntityNotFoundException("Фильма с таким названием не существует!");
        return movie;
    }

    public Movie updateMovieById(Long id, Movie movie) throws EntityNotFoundException {
        return movieRepository.findById(id)
                .map(entity -> {

                    entity.setTitle(movie.getTitle());
                    entity.setDescription(movie.getDescription());
                    return movieRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Фильм с id " + id + " не найден"));

    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
