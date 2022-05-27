package com.example.springgraphql.resolver;

import com.example.springgraphql.model.Role;
import com.example.springgraphql.model.User;
import com.example.springgraphql.repository.RoleRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserResolver implements GraphQLResolver<User> {
    private final RoleRepository roleRepository;

    public List<Role> roles(List<User> users) {
        return roleRepository.findByUsers(users);
    }
}
