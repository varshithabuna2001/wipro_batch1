package com.wiproo.movie.controller;

import com.wiproo.movie.entity.*;
import com.wiproo.movie.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        Movie saved = service.save(movie);
        return ResponseEntity.created(URI.create("/api/movies/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie) {
        try {
            Movie updated = service.update(id, movie);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // link existing genre to movie
    @PostMapping("/{movieId}/genres/{genreId}")
    public ResponseEntity<Movie> addGenre(@PathVariable Long movieId, @PathVariable Long genreId) {
        Movie updated = service.addGenreToMovie(movieId, genreId);
        return ResponseEntity.ok(updated);
    }

    // remove genre from movie
    @DeleteMapping("/{movieId}/genres/{genreId}")
    public ResponseEntity<Movie> removeGenre(@PathVariable Long movieId, @PathVariable Long genreId) {
        Movie updated = service.removeGenreFromMovie(movieId, genreId);
        return ResponseEntity.ok(updated);
    }
}
