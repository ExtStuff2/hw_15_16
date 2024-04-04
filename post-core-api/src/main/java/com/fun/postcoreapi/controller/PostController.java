package com.fun.postcoreapi.controller;

import com.fun.postcoreapi.data.entities.Post;
import com.fun.postcoreapi.data.models.PostDetails;
import com.fun.postcoreapi.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/check")
    public String checkPostCoreApi() {
        return "service is up";
    }

    @GetMapping
    public List<Post> getAllPosts(
    ) {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(
            @RequestBody @Valid Post post
    ) {
        return postService.createPost(post);
    }

    @PutMapping
    public Post updatePost(
            @RequestBody @Valid Post post
    ) {
        return postService.createPost(post);
    }

    @GetMapping("/detail/{postId}")
    public List<PostDetails> getPostDetailsByPostId(@PathVariable UUID postId) {
        return postService.getPostDetailsByPostId(postId);
    }

    @GetMapping("/post/{postId}")
    public Post getPostById(@PathVariable UUID postId) {
        return postService.findPostById(postId);
    }

}
