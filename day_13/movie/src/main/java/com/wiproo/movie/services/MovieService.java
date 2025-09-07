package com.wiproo.movie.services;

import com.wiproo.movie.entity.*;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie save(Movie movie);
    Optional<Movie> findById(Long id);
    List<Movie> findAll();
    Movie update(Long id, Movie movie);
    void deleteById(Long id);

    Movie addGenreToMovie(Long movieId, Long genreId);
    Movie removeGenreFromMovie(Long movieId, Long genreId);
}
