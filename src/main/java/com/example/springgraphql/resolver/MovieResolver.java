package com.example.springgraphql.resolver;

import com.example.springgraphql.model.Director;
import com.example.springgraphql.model.Movie;
import com.example.springgraphql.service.DirectorServiceImpl;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieResolver implements GraphQLResolver<Movie> {
    private final DirectorServiceImpl directorService;

    public Director director(Movie movie) {
        return directorService.getDirectorById(movie.getDirector().getId());
    }
}
