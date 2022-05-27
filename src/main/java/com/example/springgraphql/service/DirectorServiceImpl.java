package com.example.springgraphql.service;

import com.example.springgraphql.model.Director;
import com.example.springgraphql.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service @RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;

    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Director getDirectorById(Integer id) {
        return directorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Director with id " + id + " not found."));
    }

    @Override
    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public String deleteDirector(Integer id) {
        Director director = getDirectorById(id);
        directorRepository.deleteById(director.getId());
        return "Director with id " + id + " deleted.";
    }
}
