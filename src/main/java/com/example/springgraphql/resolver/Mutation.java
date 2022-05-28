package com.example.springgraphql.resolver;

import com.example.springgraphql.input.*;
import com.example.springgraphql.model.Director;
import com.example.springgraphql.model.Movie;
import com.example.springgraphql.model.Role;
import com.example.springgraphql.model.User;
import com.example.springgraphql.service.DirectorServiceImpl;
import com.example.springgraphql.service.MovieServiceImpl;
import com.example.springgraphql.service.RoleServiceImpl;
import com.example.springgraphql.service.UserServiceImpl;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    private final MovieServiceImpl movieService;
    private final DirectorServiceImpl directorService;

    public User createUser(UserInput input) {
        return userService.createUser(new User(input.getUsername(), input.getPassword()));
    }

    public Role createRole(RoleInput input) {
        return roleService.createRole(new Role(input.getName()));
    }

    public Movie createMovie(MovieInput input) {
        return movieService.createMovie(new Movie(input.getTitle(), input.getGenres(), input.getRuntime(), input.getCertificate(), new Director(input.getDirectorId()), input.getLanguage(), input.getReleaseDate()));
    }

    public Director createDirector(DirectorInput input) {
        return directorService.createDirector(new Director(input.getFirstName(), input.getLastName(), input.getBirthDate()));
    }

    public User updateUser(Integer id, UserInput input) {
        return userService.updateUser(id, input.getPassword());
    }

    public Movie updateMovie(Integer id, MovieInput input) {
        return movieService.updateMovie(id, input);
    }

    public Director updateDirector(Integer id, DirectorInput input) {
        return directorService.updateDirector(id, input.getBirthDate());
    }

    public String deleteUser(Integer id) {
        return userService.deleteUser(id);
    }

    public String deleteMovie(Integer id) {
        return movieService.deleteMovie(id);
    }

    public String deleteDirector(Integer id) {
        return directorService.deleteDirector(id);
    }

    public String addRoleToUser(UsernameRoleNameInput input) {
        return userService.addRoleToUser(input.getUsername(), input.getRoleName());
    }

    public String deleteRoleFromUser(UsernameRoleNameInput input) {
        return userService.deleteRoleFromUser(input.getUsername(), input.getRoleName());
    }
}
