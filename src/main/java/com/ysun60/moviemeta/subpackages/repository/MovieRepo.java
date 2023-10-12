package com.ysun60.moviemeta.subpackages.repository;

import com.ysun60.moviemeta.subpackages.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends MongoRepository<Movie, ObjectId> {
    //public Optional<MovieData> findMovieDataByTitle(String Title);
    public List<Movie> findMovieDataBytitleContainingIgnoreCase(String title);

    Movie findMovieById(String objectId);
    //public List<MovieData> findAll(Pageable pageable);

    //public Movie findMovieDataById(String id);
}
