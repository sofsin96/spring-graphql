package com.example.springgraphql.service;

import com.example.springgraphql.exception.MovieNotFoundException;
import com.example.springgraphql.input.MovieInput;
import com.example.springgraphql.model.Movie;
import com.example.springgraphql.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Integer id, MovieInput input) {
        Movie foundMovie = getMovieById(id);

        if (foundMovie != null) {
            foundMovie.setGenres(input.getGenres());
            foundMovie.setRuntime(input.getRuntime());
            foundMovie.setCertificate(input.getCertificate());
            foundMovie.setLanguage(input.getLanguage());
            foundMovie.setReleaseDate(input.getReleaseDate());
            movieRepository.save(foundMovie);
        }
        return foundMovie;
    }

    @Override
    public String deleteMovie(Integer id) {
        Movie movie = getMovieById(id);
        movieRepository.deleteById(movie.getId());
        return "Movie with id " + id + " deleted.";
    }
}
