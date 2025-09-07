package com.wiproo.media.services;

import com.wiproo.media.entity.*;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person person);
    Optional<Person> findById(Long id);
    List<Person> findAll();
    Person update(Long id, Person person);
    void deleteById(Long id);
    Person addPost(Long personId, String message);
    void removePost(Long personId, Long postId);
}
