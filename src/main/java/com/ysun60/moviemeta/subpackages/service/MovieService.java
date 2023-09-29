package com.ysun60.moviemeta.subpackages.service;

import com.ysun60.moviemeta.subpackages.data.MovieData;
import com.ysun60.moviemeta.subpackages.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public List<MovieData> findMovieByTitle(String title){
        List<MovieData> movies = movieRepo.findMovieDataBytitleContainingIgnoreCase(title);
        if (movies.isEmpty()) {
            return null;
        }
        return movies;
    }

    public List<MovieData> findAllMovies() {
        return movieRepo.findAll();
    }
}
