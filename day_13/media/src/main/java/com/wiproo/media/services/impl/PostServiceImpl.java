package com.wiproo.media.services.impl;

import com.wiproo.media.entity.*;
import com.wiproo.media.repository.*;
import com.wiproo.media.services.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repo;

    public PostServiceImpl(PostRepository repo) {
        this.repo = repo;
    }

    @Override
    public Post save(Post post) {
        return repo.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
