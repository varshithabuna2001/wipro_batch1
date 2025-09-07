package com.wiproo.movie.services.impl;

import com.wiproo.movie.entity.*;
import com.wiproo.movie.repository.*;
import com.wiproo.movie.services.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;
    private final GenreRepository genreRepo;

    public MovieServiceImpl(MovieRepository movieRepo, GenreRepository genreRepo) {
        this.movieRepo = movieRepo;
        this.genreRepo = genreRepo;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepo.findById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Movie update(Long id, Movie movie) {
        return movieRepo.findById(id).map(existing -> {
            existing.setTitle(movie.getTitle());
            existing.setGenres(movie.getGenres()); // careful: ensure helper methods used if you want both sides kept
            return movieRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Movie addGenreToMovie(Long movieId, Long genreId) {
        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + movieId));
        Genre genre = genreRepo.findById(genreId)
                .orElseThrow(() -> new RuntimeException("Genre not found: " + genreId));
        movie.addGenre(genre);
        return movieRepo.save(movie);
    }

    @Override
    @Transactional
    public Movie removeGenreFromMovie(Long movieId, Long genreId) {
        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + movieId));
        Genre genre = genreRepo.findById(genreId)
                .orElseThrow(() -> new RuntimeException("Genre not found: " + genreId));
        movie.removeGenre(genre);
        return movieRepo.save(movie);
    }
}
