package com.ysun60.moviemeta.subpackages.dto;

import com.ysun60.moviemeta.subpackages.entity.Comment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String username;
    private List<CommentDTO> comments = new ArrayList<>();
}
