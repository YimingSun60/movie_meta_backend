package com.ysun60.moviemeta.subpackages.service;

import com.ysun60.moviemeta.subpackages.Entity.Movie;
import com.ysun60.moviemeta.subpackages.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public List<Movie> findMovieByTitle(String title){
        List<Movie> movies = movieRepo.findMovieDataBytitleContainingIgnoreCase(title);
        if (movies.isEmpty()) {
            return null;
        }
        return movies;
    }

    public List<Movie> findAllMovies() {
        return movieRepo.findAll();
    }

    public Movie findMovieById(String id) {
        return movieRepo.findMovieDataById(id);
    }
}
