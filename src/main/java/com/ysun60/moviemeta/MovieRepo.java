package com.ysun60.moviemeta;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends MongoRepository<MovieData, ObjectId> {
    public Optional<MovieData> findMovieDataBytitle(String Title);
}
