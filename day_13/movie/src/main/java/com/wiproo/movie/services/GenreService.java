package com.wiproo.movie.services;

import com.wiproo.movie.entity.*;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Genre save(Genre genre);
    Optional<Genre> findById(Long id);
    Optional<Genre> findByDescription(String desc);
    List<Genre> findAll();
    void deleteById(Long id);
}
