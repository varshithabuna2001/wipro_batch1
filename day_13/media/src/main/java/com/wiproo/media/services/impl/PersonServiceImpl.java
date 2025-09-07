package com.wiproo.media.services.impl;

import com.wiproo.media.entity.*;
import com.wiproo.media.repository.*;
import com.wiproo.media.services.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepo;
    private final PostRepository postRepo;

    public PersonServiceImpl(PersonRepository personRepo, PostRepository postRepo) {
        this.personRepo = personRepo;
        this.postRepo = postRepo;
    }

    @Override
    public Person save(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepo.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public Person update(Long id, Person person) {
        return personRepo.findById(id).map(existing -> {
            existing.setName(person.getName());
            // optionally update posts list: here we replace full list if provided
            if (person.getPosts() != null) {
                existing.setPosts(person.getPosts());
            }
            return personRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Person addPost(Long personId, String message) {
        Person person = personRepo.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + personId));
        Post post = new Post(message);
        person.addPost(post); // cascade will save post when person saved
        return personRepo.save(person);
    }

    @Override
    @Transactional
    public void removePost(Long personId, Long postId) {
        Person person = personRepo.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + personId));

        // find the post in person's posts and remove it (orphanRemoval=true will delete it)
        person.getPosts().removeIf(p -> p.getId() != null && p.getId().equals(postId));
        personRepo.save(person);
    }
}
