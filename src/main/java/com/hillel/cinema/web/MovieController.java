package com.hillel.cinema.web;

import com.hillel.cinema.domain.Movie;
import com.hillel.cinema.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;
    public MovieController (MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);

    }

    @GetMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);

    }

    @GetMapping("/movies/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();

    }

    @PutMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie updateMovieById(@PathVariable("id") Long id, @RequestBody Movie movie)  {
        return movieService.updateMovieById(id, movie);
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Фильм с id" + id + " удален!");
    }

}
