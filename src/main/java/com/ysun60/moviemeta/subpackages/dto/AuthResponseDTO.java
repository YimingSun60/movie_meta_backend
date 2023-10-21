package com.ysun60.moviemeta.subpackages.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String token;
    private String tokenType = "Bearer ";
    private Long userId;


    public AuthResponseDTO(String token, Long userId){
        this.token = token;
        this.userId = userId;
    }
}
