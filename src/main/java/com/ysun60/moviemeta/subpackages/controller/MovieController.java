package com.ysun60.moviemeta.subpackages.controller;

import com.ysun60.moviemeta.subpackages.entity.Movie;
import com.ysun60.moviemeta.subpackages.service.MovieService;
import com.ysun60.moviemeta.subpackages.service.UserService;
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
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @GetMapping("/public/search")
    public ResponseEntity<List<Movie>> findMovieByTitle(@RequestParam String title) {
        List<Movie> movies = movieService.findMovieByTitle(title);
//        System.out.println("Movie: " + movies);
        if (movies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/public/movie/{id}")
    public ResponseEntity<List<Movie>>findMovieById(@PathVariable String id) {
        List<Movie> movies = movieService.findMovieById(id);

        if (movies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/public/home")
    public ResponseEntity<List<Movie>> FindAllMovies() {
        for(var movie : movieService.findAllMovies()) {
            System.out.println(movie);
        }
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

//    @GetMapping("/public/user/login")
//    public ResponseEntity<UserDTO> findUserByUserName(@RequestParam String username, @RequestParam String password) {
//        UserDTO user = userService.findUserByUserName(username,password);
//        if (user == null ) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//    @PostMapping("/public/signup")
//    public ResponseEntity<User> createUser(@RequestParam String username, @RequestParam String password) {
//        User user = userService.createUser(username, password);
//        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

    @PostMapping("/public/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }
}
