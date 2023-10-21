package com.ysun60.moviemeta.subpackages.repository;

import com.ysun60.moviemeta.subpackages.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findUserByUsername(String username);
    public User findUserById(long id);
    public boolean existsUserByUsername(String username);
}
