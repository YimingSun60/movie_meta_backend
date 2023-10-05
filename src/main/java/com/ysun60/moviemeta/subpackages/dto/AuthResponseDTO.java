package com.ysun60.moviemeta.subpackages.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String token;
    private String tokenType = "Bearer ";

    public AuthResponseDTO(String token){
        this.token = token;
    }
}
