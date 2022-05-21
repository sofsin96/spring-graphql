package com.example.springgraphql.repository;

import com.example.springgraphqlmysql.model.Role;
import com.example.springgraphqlmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    boolean existsRoleByName(String name);
    List<Role> findByUsers(List<User> users);
}
