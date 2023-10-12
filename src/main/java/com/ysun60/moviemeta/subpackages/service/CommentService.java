package com.ysun60.moviemeta.subpackages.service;


import com.ysun60.moviemeta.subpackages.entity.Comment;
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

    public void addComment(String _comment, String _username, String _movieid){
     comment.setComment(_comment);
     comment.setUserid(userRepo.findUserByUsername(_username).getId());
     comment.setMovieid(_movieid);
     commentRepo.save(comment);
    }

}
