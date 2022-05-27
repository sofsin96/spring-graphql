package com.example.springgraphql.service;

import com.example.springgraphql.model.Role;
import com.example.springgraphql.model.User;
import com.example.springgraphql.repository.RoleRepository;
import com.example.springgraphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found."));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Integer id) {
        User user = getUserById(id);
        userRepository.deleteById(user.getId());
        return "User with id " + id + " deleted.";
    }

    @Override
    public String addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        if (user == null || role == null) {
            throw new RuntimeException("Invalid username or role name.");
        }
        user.addRole(role);
        return "Role added.";
    }

    @Override
    public String deleteRoleFromUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        if (user == null || role == null) {
            throw new RuntimeException("Invalid username or role name.");
        }
        else if (role.getName().equals("USER")) {
            throw new RuntimeException("Cannot delete role USER");
        }
        else {
            user.removeRole(role);
            return "Role deleted.";
        }
    }
}
