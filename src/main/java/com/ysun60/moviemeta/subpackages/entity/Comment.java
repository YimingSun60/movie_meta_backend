package com.ysun60.moviemeta.subpackages.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {
    @Id
    private String id;
    private String comment;

    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;

    @ManyToOne
    @JoinTable(name = "movie_id")
    private Movie movie;
}
