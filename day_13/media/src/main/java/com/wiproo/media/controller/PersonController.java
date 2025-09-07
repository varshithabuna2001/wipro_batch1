package com.wiproo.media.controller;

import com.wiproo.media.entity.*;
import com.wiproo.media.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person saved = service.save(person);
        return ResponseEntity.created(URI.create("/api/persons/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        try {
            Person updated = service.update(id, person);
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

    // Add a post to person
    @PostMapping("/{id}/posts")
    public ResponseEntity<Person> addPost(@PathVariable Long id, @RequestBody String message) {
        Person updated = service.addPost(id, message);
        return ResponseEntity.ok(updated);
    }

    // Remove a specific post from person
    @DeleteMapping("/{personId}/posts/{postId}")
    public ResponseEntity<Void> removePost(@PathVariable Long personId, @PathVariable Long postId) {
        service.removePost(personId, postId);
        return ResponseEntity.noContent().build();
    }
}
