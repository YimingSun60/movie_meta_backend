package com.ysun60.moviemeta.subpackages.service;

import com.ysun60.moviemeta.subpackages.Entity.Movie;
import com.ysun60.moviemeta.subpackages.repository.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public List<Movie> findMovieById(String id) {

        Movie movie = movieRepo.findMovieById(id);

        if (movie == null) {
            return null;
        }
        return List.of(movie);
    }
}
