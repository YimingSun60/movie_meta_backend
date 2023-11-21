package com.ysun60.moviemeta.subpackages.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class MovieCollectionDTO {
    @NotEmpty
    private long userId;

    @NotEmpty
    private String movieId;
}
