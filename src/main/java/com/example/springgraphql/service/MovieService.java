package com.example.springgraphql.service;

import com.example.springgraphql.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Integer id);

    Movie createMovie(Movie movie);

    String deleteMovie (Integer id);
}
