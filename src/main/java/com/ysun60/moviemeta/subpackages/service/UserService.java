package com.ysun60.moviemeta.subpackages.service;

import com.ysun60.moviemeta.subpackages.dto.UserDTO;
import com.ysun60.moviemeta.subpackages.entity.User;
import com.ysun60.moviemeta.subpackages.dto.LoginDTO;
import com.ysun60.moviemeta.subpackages.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public LoginDTO findLoginDTOById(long id) {
        User user = userRepo.findById(id).orElse(null);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(user.getId());
        loginDTO.setUsername(user.getUsername());
        return loginDTO;
    }

    public User findUserById(long id) {
        return userRepo.findUserById(id);
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
    public UserDTO findUserDTOById(long id) {
        User user = userRepo.findUserById(id);
        if(user == null){
            System.out.println("User not found");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    public void addMovieToWatchList(long userId, String movieId) {
        User user = userRepo.findUserById(userId);
        if(user != null) {
            user.addMovieToWatchList(movieId);
            userRepo.save(user);
        }

    }

    public void removeMoviefromWatchList(long userId, String movieId){
        User user = userRepo.findUserById(userId);
        if(user != null) {
            user.removeMovieFromWatchList(movieId);
            userRepo.save(user);
        }
    }
    public List<String> getWatchList(long userId) {
        User user = userRepo.findUserById(userId);
        if(user != null) {
            return user.getCollectedMovieIds();
        }
        return null;
    }
}
