package com.ysun60.moviemeta.subpackages.service;

import com.ysun60.moviemeta.subpackages.Entity.User;
import com.ysun60.moviemeta.subpackages.dto.LoginDTO;
import com.ysun60.moviemeta.subpackages.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


    public User createUser(String userName, String passWord){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);
        return userRepo.save(user);
    }

    public LoginDTO findUserById(long id) {
        User user = userRepo.findById(id).orElse(null);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(user.getId());
        loginDTO.setUsername(user.getUsername());
        return loginDTO;
    }

    public LoginDTO findUserByUserName(String username, String password) {
        User user = userRepo.findUserByUsername(username);
        if(!user.getPassword().equals(password)) {
            return null;
        }
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(user.getId());
        loginDTO.setUsername(user.getUsername());

        return loginDTO;
    }
}
