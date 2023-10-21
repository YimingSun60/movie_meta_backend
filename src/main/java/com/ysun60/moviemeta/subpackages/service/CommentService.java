package com.ysun60.moviemeta.subpackages.service;


import com.ysun60.moviemeta.subpackages.entity.Comment;
import com.ysun60.moviemeta.subpackages.entity.User;
import com.ysun60.moviemeta.subpackages.model.CommentModel;
import com.ysun60.moviemeta.subpackages.repository.CommentRepo;
import com.ysun60.moviemeta.subpackages.repository.MovieRepo;
import com.ysun60.moviemeta.subpackages.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentRepo commentRepo;

    Comment comment = new Comment();

    public void addComment(String _comment, Long _userid, String _movieid){
     comment.setComment(_comment);
     comment.setUser(userRepo.findUserById(_userid));
     comment.setMovie(movieRepo.findMovieById(_movieid));
     commentRepo.save(comment);
    }

}
