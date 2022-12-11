package com.dev.spm.api.resources;

import com.dev.spm.api.domain.Post;
import com.dev.spm.api.resources.util.Url;
import com.dev.spm.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String minDate, @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        String search = Url.decoder(text);
        Date min = Url.convertDate(minDate, new Date(0L));
        Date max = Url.convertDate(maxDate, new Date());
        List<Post> posts = postService.fullSearch(search, min, max);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/search/title")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text") String text) {
        String search = Url.decoder(text);
        List<Post> post = postService.findByTitle(search);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/search/body")
    public ResponseEntity<List<Post>> findByBody(@RequestParam(value = "text") String text) {
        String search = Url.decoder(text);
        List<Post> posts = postService.findByBody(text);
        return ResponseEntity.ok().body(posts);
    }
}
