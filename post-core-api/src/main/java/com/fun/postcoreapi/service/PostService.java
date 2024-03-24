package com.fun.postcoreapi.service;

import com.fun.postcoreapi.data.entities.Post;
import com.fun.postcoreapi.data.models.PostDetails;
import com.fun.postcoreapi.data.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post request) {
        return postRepository.save(request);
    }

    public Post findPostById(UUID postId) {
        return postRepository.getReferenceById(postId);
    }

    public Post updatePostById(Post post) {
        if (postRepository.existsById(post.getPostId())) {
            return postRepository.save(post);
        }
        return new Post();
    }

    public List<PostDetails> getPostDetailsByPostId(UUID postId) {
        List<Object[]> result = postRepository.getPostDetails(postId);
        return result.stream()
                .map(this::mapToPostDetailsDTO)
                .collect(Collectors.toList());
    }

    private PostDetails mapToPostDetailsDTO(Object[] row) {
        PostDetails postDetailsDTO = new PostDetails();
        postDetailsDTO.setPostItem((String) row[0]);
        postDetailsDTO.setPostStatus((String) row[1]);
        postDetailsDTO.setSenderName((String) row[2]);
        postDetailsDTO.setSenderSurname((String) row[3]);
        postDetailsDTO.setReceiverName((String) row[4]);
        postDetailsDTO.setReceiverSurname((String) row[5]);
        return postDetailsDTO;
    }

}

