package com.example.bidirectional.controller;

import com.example.bidirectional.entity.Post;
import com.example.bidirectional.repository.PostRepository;
import com.example.bidirectional.repository.TagRepository;
import com.example.bidirectional.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        postService.createPost(post);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }
}
