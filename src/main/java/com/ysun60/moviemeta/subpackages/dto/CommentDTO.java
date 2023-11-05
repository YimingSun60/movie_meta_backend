package com.ysun60.moviemeta.subpackages.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDTO {
    private String id;

    @NotEmpty
    private String comment;

    @NotEmpty
    private long userId;

    @NotEmpty
    private String movieId;

    @NotEmpty
    private String movieTitle;

    @NotEmpty
    private String userName;


}
