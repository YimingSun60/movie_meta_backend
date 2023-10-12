package com.ysun60.moviemeta.subpackages.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long userid;
    private String movieid;
}
