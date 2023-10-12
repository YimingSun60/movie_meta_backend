package com.ysun60.moviemeta.subpackages.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentModel {
    private String comment;
    private String userid;
    private String movieid;
}
