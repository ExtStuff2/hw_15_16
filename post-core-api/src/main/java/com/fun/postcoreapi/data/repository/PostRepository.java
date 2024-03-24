package com.fun.postcoreapi.data.repository;

import com.fun.postcoreapi.data.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {


    @Query(value = "SELECT post_item, post_status, MAX(CASE WHEN post.client_id = client.client_id THEN client.client_name END) AS sender_name," +
            "MAX(CASE WHEN post.client_id = client.client_id THEN client.client_surname END) AS sender_surname," +
            "MAX(CASE WHEN post.receiver_id = client.client_id THEN client.client_name END) AS receiver_name," +
            "MAX(CASE WHEN post.receiver_id = client.client_id THEN client.client_surname END) AS receiver_surname " +
            "FROM post JOIN client ON client.client_id = post.client_id OR client.client_id = post.receiver_id WHERE post.post_id = :postId GROUP BY post_item, post_status;", nativeQuery = true)
    List<Object[]> getPostDetails(@Param("postId") UUID postId);


}
