package com.wiproo.movie.controller;

import com.wiproo.movie.entity.*;
import com.wiproo.movie.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Genre> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Genre> create(@RequestBody Genre genre) {
        Genre saved = service.save(genre);
        return ResponseEntity.created(URI.create("/api/genres/" + saved.getId())).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
