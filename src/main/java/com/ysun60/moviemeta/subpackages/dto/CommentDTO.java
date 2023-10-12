package com.ysun60.moviemeta.subpackages.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CommentDTO {
    private String id;

    @NotEmpty
    private String comment;

    @NotEmpty
    private String movieId;

    @NotEmpty
    private String username;
}
