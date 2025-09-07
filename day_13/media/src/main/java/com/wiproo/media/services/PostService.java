package com.wiproo.media.services;

import com.wiproo.media.entity.*;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(Post post);
    Optional<Post> findById(Long id);
    List<Post> findAll();
    void deleteById(Long id);
}
