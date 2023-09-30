package com.ysun60.moviemeta.subpackages.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private long id;

    @NotEmpty(message = "username cannot be empty")
    private String userName;

// haven't implemented the email yet
//    @NotEmpty(message = "email cannot be empty")
//    @Email
//    private String email;


}
