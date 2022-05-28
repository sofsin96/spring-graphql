package com.example.springgraphql.service;

import com.example.springgraphql.model.Role;
import com.example.springgraphql.model.User;
import com.example.springgraphql.repository.RoleRepository;
import com.example.springgraphql.repository.UserRepository;
import com.example.springgraphql.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with username %s not found in the database.";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

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
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new RuntimeException(user.getUsername() + " already exists in the database");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(roleRepository.findByName("USER"));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, String password) {
        User foundUser = getUserById(id);

        if (foundUser != null) {
            foundUser.setPassword(passwordEncoder.encode(password));
            userRepository.save(foundUser);
        }
        return foundUser;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username));
        }
        return new UserPrincipal(user);
    }
}
