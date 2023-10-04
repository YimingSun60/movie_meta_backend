package com.ysun60.moviemeta.subpackages.controller;

import com.ysun60.moviemeta.subpackages.Entity.Role;
import com.ysun60.moviemeta.subpackages.Entity.User;
import com.ysun60.moviemeta.subpackages.dto.RegisterDTO;
import com.ysun60.moviemeta.subpackages.repository.RoleRepo;
import com.ysun60.moviemeta.subpackages.repository.UserRepo;
import com.ysun60.moviemeta.subpackages.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {
    SecurityConfiguration securityConfiguration;
    UserRepo userRepo;
    RoleRepo roleRepo;
    PasswordEncoder passwordEncoder;
    @Autowired
    public AuthController(SecurityConfiguration securityConfiguration, UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.securityConfiguration = securityConfiguration;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }



    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        if(userRepo.existsUserByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role role = roleRepo.findRoleByName("USER");
        user.setRoles(Collections.singletonList(role));
        userRepo.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

}
