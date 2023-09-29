package com.ysun60.moviemeta.subpackages.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;


    @Getter
    @Setter
    private String username;


    @Getter
    @Setter
    private String password;
}
