package com.fun.postofficeapi.controllers;

import com.fun.postofficeapi.models.Post;
import com.fun.postofficeapi.models.PostDetails;
import com.fun.postofficeapi.proxy.PostPostsProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PostPostsController {

    private final PostPostsProxy postPostProxy;

    public PostPostsController(PostPostsProxy postPostsProxy) {
        this.postPostProxy = postPostsProxy;
    }


    @GetMapping("/posts")
    public List<Post> getAllPostPosts() {
        return postPostProxy.getPosts().getBody();
    }

    @GetMapping("/posts/detail/{postId}")
    public List<PostDetails> getPostDetailsByPostId(@PathVariable UUID postId) {
        return postPostProxy.getPostDetailsByPostId(postId).getBody();
    }

    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable UUID postId) {
        return postPostProxy.getPostById(postId).getBody();
    }

    @GetMapping("/posts/check")
    public String checkPost() {
        return postPostProxy.checkPost().getBody();
    }
}
