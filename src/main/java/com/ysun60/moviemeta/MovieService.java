package com.ysun60.moviemeta;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;
    public List<MovieData> allMovies(){
        return movieRepo.findAll();
    }
    /*public Optional<MovieData> findMovie(ObjectId id){
        return movieRepo.findById(id);
    }*/
    public  Optional<MovieData> findMovie(String Title){
        System.out.println(Title);
        return movieRepo.findMovieDataBytitle(Title);
    }
}
