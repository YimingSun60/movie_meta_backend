package com.ysun60.moviemeta.subpackages.data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//collection name should match the actual mongodata collection name
@Document(collection = "movie")
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class MovieData {
    @Id
    private ObjectId id;
    private String title;
    private Integer year;
    private List<String> cast;
    private List<String> genres;
    private String href;
    private String extract;
    private String thumbnail;
    private Integer thumbnail_width;
    private Integer thumbnail_height;
}
