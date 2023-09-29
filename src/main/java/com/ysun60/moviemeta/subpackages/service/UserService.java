package com.ysun60.moviemeta.subpackages.service;

import com.ysun60.moviemeta.subpackages.data.User;
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
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User findUserByUserName(String username) {
        return userRepo.findUserByUsername(username);
    }
}
