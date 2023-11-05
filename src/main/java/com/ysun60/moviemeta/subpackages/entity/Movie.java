package com.ysun60.moviemeta.subpackages.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

//collection name should match the actual mongodata collection name
@Document(collection = "movie")
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    private String title;
    private Integer year;
    private List<String> cast;
    private List<String> genres;
    private String href;
    private String extract;
    private String thumbnail;
    private Integer thumbnail_width;
    private Integer thumbnail_height;

    @DBRef()
    //@JsonIgnore
    private List<Comment> comments;

    public void addComment(Comment comment) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(comment);
    }
}
