package com.example.demo.controller;



import com.example.demo.entity.Movie;
import com.example.demo.services.MovieService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Simple GET endpoint to test if the server is running
    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to the Movie API!";
    }

    // POST request to add movies using the Movie entity
    @PostMapping("/movies")
    public String createMovie(@RequestBody Movie movie) {
        // Call the service to save the movie
        movieService.saveMovie(movie);
        return "Movie added successfully!";
    }

    @GetMapping("/movies")
public List<Movie> getAllMovies() {
    return movieService.getAllMovies();  // This returns the list of movies
}

 // DELETE request to delete a movie by ID
 @DeleteMapping("/movies/{id}")
 public String deleteMovieById(@PathVariable Long id) {
     boolean isRemoved = movieService.deleteMovieById(id);  // Call service to delete
     if (isRemoved) {
         return "Movie deleted successfully!";
     } else {
         return "Movie not found!";
     }
 }
}