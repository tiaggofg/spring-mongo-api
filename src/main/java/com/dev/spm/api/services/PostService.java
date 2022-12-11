package com.dev.spm.api.services;

import com.dev.spm.api.domain.Post;
import com.dev.spm.api.repositories.PostRepository;
import com.dev.spm.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post id: " + id + " não encontrado!"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContaining(text);
    }

    public List<Post> findByBody(String text) {
        return postRepository.findByBody(text);
    }
}
