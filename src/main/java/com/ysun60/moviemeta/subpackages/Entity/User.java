package com.ysun60.moviemeta.subpackages.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, unique = true)
    private String username;


    @Column(nullable = false)
    private String password;
}
