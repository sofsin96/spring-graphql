package com.example.springgraphql.repository;

import com.example.springgraphql.model.Role;
import com.example.springgraphql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    boolean existsRoleByName(String name);
    List<Role> findByUsers(List<User> users);
}
