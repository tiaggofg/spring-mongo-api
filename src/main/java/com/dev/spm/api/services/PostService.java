package com.dev.spm.api.services;

import com.dev.spm.api.domain.Post;
import com.dev.spm.api.repositories.PostRepository;
import com.dev.spm.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        List<Post> posts = postRepository.findByTitleContaining(text);
        if (posts.isEmpty()) {
            throw new ObjectNotFoundException("Nenhum post encontrado!");
        }
        return posts;
    }

    public List<Post> findByBody(String text) {
        List<Post> posts = postRepository.findByBody(text);
        if (posts.isEmpty()) {
            throw new ObjectNotFoundException("Nenhum post encontrado!");
        }
        return posts;
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        List<Post> posts = postRepository.fullSearch(text, minDate, maxDate);
        if (posts.isEmpty()) {
            throw new ObjectNotFoundException("Nenhum post encontrado!");
        }
        return posts;
    }
}
