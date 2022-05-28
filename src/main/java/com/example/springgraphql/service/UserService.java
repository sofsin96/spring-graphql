package com.example.springgraphql.service;

import com.example.springgraphql.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    User createUser(User user);

    User updateUser(Integer id, String password);

    String deleteUser (Integer id);

    String addRoleToUser(String username, String roleName);

    String deleteRoleFromUser(String username, String roleName);
}
