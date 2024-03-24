package com.fun.postcoreapi.data.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postId;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "receiver_id")
    private UUID receiverId;

    private String postItem;
    private String postStatus;
}
