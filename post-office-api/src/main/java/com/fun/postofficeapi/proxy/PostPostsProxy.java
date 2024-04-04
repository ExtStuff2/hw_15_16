package com.fun.postofficeapi.proxy;

import com.fun.postofficeapi.models.Post;
import com.fun.postofficeapi.models.PostDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "posts", url = "http://localhost:8083")
public interface PostPostsProxy {

    @GetMapping("/posts")
    ResponseEntity<List<Post>> getPosts();

    @GetMapping("/posts/detail/{postId}")
    ResponseEntity<List<PostDetails>> getPostDetailsByPostId(@PathVariable UUID postId);

    @GetMapping("posts/post/{postId}")
    ResponseEntity<Post> getPostById(@PathVariable UUID postId);

    @GetMapping("posts/check")
    ResponseEntity<String> checkPost();

}
