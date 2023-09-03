package com.ysun60.moviemeta;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/{title}")
    //PathVariable Name should match the GetMapping
    public ResponseEntity<Optional<MovieData>> AllMovies(@PathVariable String title){
        return new ResponseEntity<Optional<MovieData>>(movieService.findMovie(title), HttpStatus.OK);
    }

}
