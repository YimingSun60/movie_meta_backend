package com.ysun60.moviemeta.subpackages.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {
    @Id
    private String id;
    private String comment;


    private long userid;

    private String username;

    @JsonIgnore
    private Movie movie;


}
