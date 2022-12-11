package com.dev.spm.api.resources;

import com.dev.spm.api.domain.Post;
import com.dev.spm.api.resources.util.Url;
import com.dev.spm.api.services.PostService;
import com.dev.spm.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title") String text) {
        String search = Url.decoder(text);
        List<Post> post = postService.findByTitle(search);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Não foram enconstrados posts contendo " + search);
        }
        return ResponseEntity.ok().body(post);
    }
    @GetMapping(value = "/searchInTheBody")
    public ResponseEntity<List<Post>> findByBody(@RequestParam(value = "text") String text) {
        String search = Url.decoder(text);
        List<Post> posts = postService.findByBody(text);
        if (posts.isEmpty()) {
            throw new ObjectNotFoundException("Não foram enconstrados posts contendo " + search);
        }
        return ResponseEntity.ok().body(posts);
    }
}
