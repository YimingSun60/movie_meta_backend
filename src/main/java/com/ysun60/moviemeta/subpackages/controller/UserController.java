package com.ysun60.moviemeta.subpackages.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/myprofile")
    public ResponseEntity<String> myProfile() {
        return new ResponseEntity<>("user profile", org.springframework.http.HttpStatus.OK);
    }
}
