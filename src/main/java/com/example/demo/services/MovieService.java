package com.example.demo.services;


import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);  // Persist the movie to the DB
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);  // Fetch movie from the DB
    }
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();  // Fetch all movies from the DB
    }

    public boolean deleteMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);  // Check if movie exists
        if (movie.isPresent()) {
            movieRepository.deleteById(id);  // Delete the movie by ID
            return true;
        }
        return false;
    }
    
}