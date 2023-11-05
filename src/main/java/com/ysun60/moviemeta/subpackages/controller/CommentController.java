package com.ysun60.moviemeta.subpackages.controller;

import com.ysun60.moviemeta.subpackages.dto.CommentDTO;
import com.ysun60.moviemeta.subpackages.entity.Comment;
import com.ysun60.moviemeta.subpackages.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @PostMapping("add")
    public ResponseEntity<Comment> addComment(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        System.out.println(commentDTO.getMovieTitle());
        commentService.addComment(comment,commentDTO.getComment(), commentDTO.getUserId(),commentDTO.getUserName(),commentDTO.getMovieId());
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
