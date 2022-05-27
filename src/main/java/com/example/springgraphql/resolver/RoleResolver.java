package com.example.springgraphql.resolver;

import com.example.springgraphql.model.Role;
import com.example.springgraphql.model.User;
import com.example.springgraphql.repository.UserRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RoleResolver implements GraphQLResolver<Role> {
    private final UserRepository userRepository;

    public List<User> users(List<Role> roles) {
        return userRepository.findByRoles(roles);
    }
}
