package com.ysun60.moviemeta.subpackages.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
public class LoginDTO {
    private long id;

    @NotEmpty(message = "username cannot be empty")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    private String password;

// haven't implemented the email yet
//    @NotEmpty(message = "email cannot be empty")
//    @Email
//    private String email;


}
