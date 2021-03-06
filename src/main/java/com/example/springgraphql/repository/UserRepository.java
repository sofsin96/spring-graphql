package com.example.springgraphql.repository;

import com.example.springgraphql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    boolean existsUserByUsername(String username);
}
