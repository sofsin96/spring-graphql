package com.example.springgraphql.resolver;

import com.example.springgraphql.model.Director;
import com.example.springgraphql.model.Movie;
import com.example.springgraphql.model.Role;
import com.example.springgraphql.model.User;
import com.example.springgraphql.service.DirectorServiceImpl;
import com.example.springgraphql.service.MovieServiceImpl;
import com.example.springgraphql.service.RoleServiceImpl;
import com.example.springgraphql.service.UserServiceImpl;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Query implements GraphQLQueryResolver {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    private final MovieServiceImpl movieService;
    private final DirectorServiceImpl directorService;

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    public User getUserById(Integer id) {
        return userService.getUserById(id);
    }

    public Role getRoleById(Integer id) {
        return roleService.getRoleById(id);
    }

    public Movie getMovieById(Integer id) {
        return movieService.getMovieById(id);
    }

    public Director getDirectorById(Integer id) {
        return directorService.getDirectorById(id);
    }
}
