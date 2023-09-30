package com.ysun60.moviemeta.subpackages.service;

import com.ysun60.moviemeta.subpackages.Entity.User;
import com.ysun60.moviemeta.subpackages.dto.UserDTO;
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

    public UserDTO findUserById(long id) {
        User user = userRepo.findById(id).orElse(null);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUsername());
        return userDTO;
    }

    public UserDTO findUserByUserName(String username) {
        User user = userRepo.findUserByUsername(username);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUsername());
        return userDTO;
    }
}
