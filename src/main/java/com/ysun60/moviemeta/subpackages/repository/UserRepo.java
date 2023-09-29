package com.ysun60.moviemeta.subpackages.repository;

import com.ysun60.moviemeta.subpackages.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findUserByUsername(String username);
}
