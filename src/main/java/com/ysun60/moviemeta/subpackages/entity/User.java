package com.ysun60.moviemeta.subpackages.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @Getter
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "user_collected_movies", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "movie_id")
    private List<String> collectedMovieIds;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();

    public void addMovieToWatchList(String movieId) {
        if (this.collectedMovieIds == null) {
            this.collectedMovieIds = new ArrayList<>();
        }
        if(!collectedMovieIds.contains(movieId)) {
            this.collectedMovieIds.add(movieId);
        }
    }

    public void removeMovieFromWatchList(String movieId) {
        if (this.collectedMovieIds == null) {
            this.collectedMovieIds = new ArrayList<>();
        }
        if(collectedMovieIds.contains(movieId)) {
            this.collectedMovieIds.remove(movieId);
        }
    }



}
