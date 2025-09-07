package com.wiproo.movie.services.impl;

import com.wiproo.movie.entity.*;
import com.wiproo.movie.repository.*;
import com.wiproo.movie.services.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repo;

    public GenreServiceImpl(GenreRepository repo) {
        this.repo = repo;
    }

    @Override
    public Genre save(Genre genre) {
        // avoid duplicate genres by description if desired
        return repo.findByDescription(genre.getDescription())
                .orElseGet(() -> repo.save(genre));
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Genre> findByDescription(String desc) {
        return repo.findByDescription(desc);
    }

    @Override
    public List<Genre> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
