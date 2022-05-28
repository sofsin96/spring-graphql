package com.example.springgraphql.resolver;

import com.example.springgraphql.model.User;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserResolver implements GraphQLResolver<User> {
}
