package com.example.springgraphql.service;

import com.example.springgraphql.model.Director;

import java.util.List;

public interface DirectorService {
    List<Director> getAllDirectors();

    Director getDirectorById(Integer id);

    Director createDirector(Director director);

    Director updateDirector(Integer id, String birthDate);

    String deleteDirector (Integer id);
}
