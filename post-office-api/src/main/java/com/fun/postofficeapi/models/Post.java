package com.fun.postofficeapi.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class Post {
    private UUID postId;
    private UUID clientId;
    private UUID receiverId;
    private String postItem;
    private String postStatus;
}
