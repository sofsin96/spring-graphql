package com.example.springgraphql.resolver;

import com.example.springgraphql.model.Role;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleResolver implements GraphQLResolver<Role> {
}
