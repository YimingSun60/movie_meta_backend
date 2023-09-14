package com.ysun60.moviemeta.subpackages.controller;

import com.ysun60.moviemeta.subpackages.data.MovieData;
import com.ysun60.moviemeta.subpackages.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {

    @GetMapping("/")
    public ResponseEntity<String> Test() {
        return new ResponseEntity<>("HelloWorld", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostConstruct
    public void init() {
        System.out.println("MovieController initialized!");
    }

    @Autowired
    private MovieRepo movieRepo;
    @GetMapping("/search")
    public ResponseEntity<List<MovieData>> findMovieByTitle(@RequestParam String title){
        List<MovieData> movies = movieRepo.findMovieDataBytitleContainingIgnoreCase(title);
        System.out.println("Movie: " + movies);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/root")
    public ResponseEntity<List<MovieData>> FindAllMovies(){
        return new ResponseEntity<>(movieRepo.findAll(), HttpStatus.OK);
    }

}
