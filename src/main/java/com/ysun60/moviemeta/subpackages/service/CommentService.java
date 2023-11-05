package com.ysun60.moviemeta.subpackages.service;


import com.ysun60.moviemeta.subpackages.dto.CommentDTO;
import com.ysun60.moviemeta.subpackages.dto.UserDTO;
import com.ysun60.moviemeta.subpackages.entity.Comment;
import com.ysun60.moviemeta.subpackages.entity.Movie;
import com.ysun60.moviemeta.subpackages.entity.User;
import com.ysun60.moviemeta.subpackages.model.CommentModel;
import com.ysun60.moviemeta.subpackages.repository.CommentRepo;
import com.ysun60.moviemeta.subpackages.repository.MovieRepo;
import com.ysun60.moviemeta.subpackages.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentRepo commentRepo;


    @Transactional
    public Comment addComment(Comment comment, String _comment, Long _userid, String _username, String _movieid) {
        // Find the movie, handle the case where the movie is not found
        Movie movie = movieRepo.findMovieById(_movieid);
        System.out.println("movie id: " + _movieid);
//        System.out.println("user id: " + _userid);
//        System.out.println("comment: " + _comment);
        if (movie == null) {
            // Handle the case where the movie doesn't exist
            // Could throw a custom exception or return null
            throw new EntityNotFoundException("Movie not found");
        }

        // Set properties on the comment
        comment.setComment(_comment);
        comment.setUserid(_userid);
        comment.setMovie(movie);
        comment.setUsername(_username);

        // Save the comment, which also saves the movie due to the relationship
        comment = commentRepo.save(comment);

        // No need to save the movie if you have cascade options set correctly
        // If you don't have cascade options, then you need to manually save the movie
        movie.addComment(comment);
        movieRepo.save(movie);

        return comment;
    }

    public UserDTO fillCommentList(UserDTO userDTO) {
        for (Comment comment : commentRepo.findAll()) {
            if (comment.getUserid() != 0) {
                if (comment.getUserid() == userDTO.getId()) {
                    CommentDTO commentDTO = new CommentDTO(comment.getId(), comment.getComment(), comment.getUserid(), comment.getMovie().getId(), comment.getMovie().getTitle(), comment.getUsername());
                    userDTO.getComments().add(commentDTO);
                }
            }
        }
        return userDTO;
    }

}
