package com.ysun60.moviemeta.subpackages.controller;

import com.ysun60.moviemeta.subpackages.Entity.MovieData;
import com.ysun60.moviemeta.subpackages.Entity.User;
import com.ysun60.moviemeta.subpackages.dto.UserDTO;
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

    @GetMapping("/search")
    public ResponseEntity<List<MovieData>> findMovieByTitle(@RequestParam String title) {
        List<MovieData> movies = movieService.findMovieByTitle(title);
//        System.out.println("Movie: " + movies);
        if (movies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @GetMapping("/root")
    public ResponseEntity<List<MovieData>> FindAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/user/login")
    public ResponseEntity<UserDTO> findUserByUserName(@RequestParam String username) {
        UserDTO user = userService.findUserByUserName(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/user/signup")
    public ResponseEntity<User> createUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.createUser(username, password);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
