package com.ysun60.moivemeta.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Vector;

@Document("moviedata")
public record MovieData(@Id String ID, String title, int year, Vector cast, Vector genres, String href,
                        String extract, String thumbnail, int thumbnail_width, int thumbnail_height) { }
