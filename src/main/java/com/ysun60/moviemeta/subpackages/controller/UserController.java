package com.ysun60.moviemeta.subpackages.controller;


import com.ysun60.moviemeta.subpackages.dto.UserDTO;
import com.ysun60.moviemeta.subpackages.service.CommentService;
import com.ysun60.moviemeta.subpackages.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;
    @GetMapping("myprofile/{id}")
    public ResponseEntity<UserDTO> myProfile(@PathVariable long id) {
        try {
            UserDTO userDTO =  userService.findUserDTOById(id);
            userDTO = commentService.fillCommentList(userDTO);
            //System.out.println(userDTO);
            return new ResponseEntity<>(userDTO, org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            //System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
