package com.example.springgraphql.resolver;

import com.example.springgraphql.model.Director;
import com.example.springgraphql.model.Movie;
import com.example.springgraphql.repository.MovieRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DirectorResolver implements GraphQLResolver<Director> {
    private final MovieRepository movieRepository;

    public List<Movie> movies(Director director) {
        return movieRepository.findByDirectorId(director.getId());
    }
}
