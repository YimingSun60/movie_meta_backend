package com.ysun60.moviemeta.subpackages.repository;

import com.ysun60.moviemeta.subpackages.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    public Role findRoleByName(String name);
}
