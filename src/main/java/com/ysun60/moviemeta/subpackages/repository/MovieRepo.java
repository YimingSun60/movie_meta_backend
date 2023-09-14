package com.ysun60.moviemeta.subpackages.repository;

import com.ysun60.moviemeta.subpackages.data.MovieData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends MongoRepository<MovieData, ObjectId> {
    //public Optional<MovieData> findMovieDataByTitle(String Title);
    public List<MovieData> findMovieDataBytitleContainingIgnoreCase(String title);
}
